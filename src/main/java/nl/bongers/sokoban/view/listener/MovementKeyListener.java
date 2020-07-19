package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.event.MainMenuEvent;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.view.GameFrame;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;
import static nl.bongers.sokoban.config.GameConfiguration.*;

public class MovementKeyListener implements KeyListener {

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        final ScenePanel scene = GameFrame.getFrame().getGame().getScene();
        final Player player = scene.getPlayer();

        switch (keyEvent.getKeyCode()) {
            case VK_W:
            case VK_KP_UP:
                player.setColor(Color.ORANGE);
                if (player.getRow() - POINTS_PER_SQUARE != 0) {
                    player.setRow(player.getRow() - POINTS_PER_SQUARE);
                }
                break;
            case VK_D:
            case VK_KP_RIGHT:
                player.setColor(Color.BLUE);
                if (player.getColumn() + POINTS_PER_SQUARE != (COLUMNS * POINTS_PER_SQUARE) - POINTS_PER_SQUARE) {
                    player.setColumn(player.getColumn() + POINTS_PER_SQUARE);
                }
                break;
            case VK_S:
            case VK_KP_DOWN:
                player.setColor(Color.MAGENTA);
                if (player.getRow() + POINTS_PER_SQUARE != (ROWS * POINTS_PER_SQUARE) - POINTS_PER_SQUARE) {
                    player.setRow(player.getRow() + POINTS_PER_SQUARE);
                }
                break;
            case VK_A:
            case VK_KP_LEFT:
                player.setColor(Color.RED);
                if (player.getColumn() - POINTS_PER_SQUARE != 0) {
                    player.setColumn(player.getColumn() - POINTS_PER_SQUARE);
                }
                break;
            case VK_ESCAPE:
                SimpleEventBus.getBus().publish(new MainMenuEvent());
                break;
            default:
                break;
        }

        scene.repaint();
    }

    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Do nothing
    }

    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Do nothing
    }
}
