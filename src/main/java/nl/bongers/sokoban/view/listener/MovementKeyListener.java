package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.model.*;

import java.awt.event.KeyEvent;
import java.util.function.IntFunction;

import static java.awt.event.KeyEvent.*;

public class MovementKeyListener extends DefaultKeyListener {

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        final Player player = getPlayer();
        final Object[][] scene = getScenePanel().getScene();

        switch (keyEvent.getKeyCode()) {
            case VK_W:
            case VK_KP_UP:
                move(player, scene, fr -> fr - 1, fc -> fc, sr -> sr - 2, sc -> sc);
                break;
            case VK_D:
            case VK_KP_RIGHT:
                move(player, scene, fr -> fr, fc -> fc + 1, sr -> sr, sc -> sc + 2);
                break;
            case VK_S:
            case VK_KP_DOWN:
                move(player, scene, fr -> fr + 1, fc -> fc, sr -> sr + 2, sc -> sc);
                break;
            case VK_A:
            case VK_KP_LEFT:
                move(player, scene, fr -> fr, fc -> fc - 1, sr -> sr, sc -> sc - 2);
                break;
            default:
                break;
        }

        scene[player.getRow()][player.getColumn()] = player;
        getScenePanel().repaint();
    }

    private void move(final Player player, final Object[][] scene, final IntFunction<Integer> row, final IntFunction<Integer> column, final IntFunction<Integer> nextRow, final IntFunction<Integer> nextColumn) {
        final int currentRow = player.getRow();
        final int currentColumn = player.getColumn();

        final int toRow = row.apply(player.getRow());
        final int toColumn = column.apply(player.getColumn());

        final int secondRow = nextRow.apply(player.getRow());
        final int secondColumn = nextColumn.apply(player.getColumn());

        if (scene[toRow][toColumn] instanceof Cell) {
            scene[currentRow][currentColumn] = scene[toRow][toColumn];
            player.setRow(toRow);
            player.setColumn(toColumn);
        } else if (scene[toRow][toColumn] instanceof Box && scene[secondRow][secondColumn] instanceof Cell) {
            scene[currentRow][currentColumn] = scene[secondRow][secondColumn];
            scene[secondRow][secondColumn] = scene[toRow][toColumn];
            player.setRow(toRow);
            player.setColumn(toColumn);
        } else if (scene[toRow][toColumn] instanceof Box && scene[secondRow][secondColumn] instanceof Goal) {
            scene[currentRow][currentColumn] = new Cell(currentRow, currentColumn);
            scene[secondRow][secondColumn] = new GoalBox(toRow, toColumn);
            player.setRow(toRow);
            player.setColumn(toColumn);
        }
    }
}
