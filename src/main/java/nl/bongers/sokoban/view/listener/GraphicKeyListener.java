package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.model.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class GraphicKeyListener extends DefaultKeyListener {

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        final Player player = getPlayer();

        switch (keyEvent.getKeyCode()) {
            case VK_W:
            case VK_KP_UP:
                player.setColor(Color.ORANGE);
                break;
            case VK_D:
            case VK_KP_RIGHT:
                player.setColor(Color.BLUE);
                break;
            case VK_S:
            case VK_KP_DOWN:
                player.setColor(Color.MAGENTA);
                break;
            case VK_A:
            case VK_KP_LEFT:
                player.setColor(Color.RED);
                break;
            default:
                break;
        }

        getScenePanel().repaint();
    }
}
