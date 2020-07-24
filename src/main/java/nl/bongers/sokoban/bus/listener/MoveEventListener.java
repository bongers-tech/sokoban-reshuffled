package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import nl.bongers.sokoban.model.*;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.awt.event.KeyEvent.*;
import static java.util.Objects.nonNull;

public class MoveEventListener implements Subscribable {

    @Override
    public void handle(final Event event) {
        final MoveEvent moveEvent = (MoveEvent) event;
        final ScenePanel scenePanel = moveEvent.getScenePanel();
        final Scene scene = scenePanel.getScene();
        final KeyEvent keyEvent = moveEvent.getKeyEvent();

        switch (keyEvent.getKeyCode()) {
            case VK_W:
            case VK_KP_UP:
                move(scene, Move.NORTH);
                break;
            case VK_D:
            case VK_KP_RIGHT:
                move(scene, Move.EAST);
                break;
            case VK_S:
            case VK_KP_DOWN:
                move(scene, Move.SOUTH);
                break;
            case VK_A:
            case VK_KP_LEFT:
                move(scene, Move.WEST);
                break;
            default:
                break;
        }

        scenePanel.repaint();
    }

    @Override
    public Set<Class<? extends Event>> subscribedEvents() {
        return Stream.of(MoveEvent.class).collect(Collectors.toCollection(HashSet::new));
    }

    private void move(final Scene scene, final Move move) {
        final Player player = scene.getPlayer();
        final Object[][] grid = scene.getGrid();
        final Map<String, Goal> goals = scene.getGoals();

        final int currentRow = player.getRow();
        final int currentColumn = player.getColumn();

        final int toRow = move.firstRow().apply(player.getRow());
        final int toColumn = move.firstColumn().apply(player.getColumn());

        final int secondRow = move.secondRow().apply(player.getRow());
        final int secondColumn = move.secondColumn().apply(player.getColumn());

        if (grid[toRow][toColumn] instanceof Cell || grid[toRow][toColumn] instanceof Goal) {
            grid[currentRow][currentColumn] = new Cell(currentRow, currentColumn);
            player.setRow(toRow);
            player.setColumn(toColumn);
        } else if (grid[toRow][toColumn] instanceof Box && grid[secondRow][secondColumn] instanceof Cell) {
            grid[currentRow][currentColumn] = grid[secondRow][secondColumn];
            grid[secondRow][secondColumn] = grid[toRow][toColumn];
            player.setRow(toRow);
            player.setColumn(toColumn);
        } else if (grid[toRow][toColumn] instanceof Box && grid[secondRow][secondColumn] instanceof Goal) {
            grid[currentRow][currentColumn] = new Cell(currentRow, currentColumn);
            grid[secondRow][secondColumn] = new GoalBox(secondRow, secondColumn);
            player.setRow(toRow);
            player.setColumn(toColumn);
            scene.getGoals().remove(secondRow + "" + secondColumn);
        }

        grid[player.getRow()][player.getColumn()] = player;
        if (nonNull(goals.get(currentRow + "" + currentColumn)) && grid[currentRow][currentColumn] instanceof Cell) {
            grid[currentRow][currentColumn] = new Goal(currentRow, currentColumn);
        }
    }
}
