package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import nl.bongers.sokoban.model.*;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.event.KeyEvent;
import java.util.Set;

import static java.awt.event.KeyEvent.*;
import static java.util.Objects.isNull;

public class MoveEventListener implements Subscribable {

    @Override
    public void handle(final Event event) {
        final MoveEvent moveEvent = (MoveEvent) event;
        final ScenePanel scenePanel = moveEvent.getScenePanel();
        final Scene scene = scenePanel.getScene();
        final KeyEvent keyEvent = moveEvent.getKeyEvent();

        switch (keyEvent.getKeyCode()) {
            case VK_W, VK_KP_UP -> move(scene, Move.NORTH);
            case VK_D, VK_KP_RIGHT -> move(scene, Move.EAST);
            case VK_S, VK_KP_DOWN -> move(scene, Move.SOUTH);
            case VK_A, VK_KP_LEFT -> move(scene, Move.WEST);
        }

        scenePanel.repaint();
    }

    @Override
    public Set<Class<? extends Event>> subscribedEvents() {
        return Set.of(MoveEvent.class);
    }

    private void move(final Scene scene, final Move move) {
        final Player player = scene.getPlayer();
        final Tile[][] tiles = scene.getTiles();
        final Entity[][] entities = scene.getEntities();

        final int currentRow = player.getRow();
        final int currentColumn = player.getColumn();

        final int targetRow = move.firstRow().apply(currentRow);
        final int targetColumn = move.firstColumn().apply(currentColumn);

        final int boxTargetRow = move.secondRow().apply(currentRow);
        final int boxTargetColumn = move.secondColumn().apply(currentColumn);

        if (tiles[targetRow][targetColumn] != Tile.WALL) {

            final Entity targetEntity = entities[targetRow][targetColumn];

            if (isNull(targetEntity)) {
                entities[currentRow][currentColumn] = null;
                entities[targetRow][targetColumn] = player;
                player.setPosition(targetRow, targetColumn);
            } else if (targetEntity instanceof Box) {
                if (tiles[boxTargetRow][boxTargetColumn] != Tile.WALL && isNull(entities[boxTargetRow][boxTargetColumn])) {
                    entities[targetRow][targetColumn] = null;
                    entities[boxTargetRow][boxTargetColumn] = targetEntity;
                    targetEntity.setPosition(boxTargetRow, boxTargetColumn);

                    entities[currentRow][currentColumn] = null;
                    entities[targetRow][targetColumn] = player;
                    player.setPosition(targetRow, targetColumn);
                }
            }
        }
    }
}
