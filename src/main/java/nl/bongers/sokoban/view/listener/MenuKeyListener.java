package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.event.MainMenuEvent;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_ESCAPE;

public class MenuKeyListener extends DefaultKeyListener {

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == VK_ESCAPE) {
            SimpleEventBus.getBus().publish(new MainMenuEvent());
        }
        getScenePanel().repaint();
    }
}
