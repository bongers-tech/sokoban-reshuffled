package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.view.Sokoban;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

abstract class DefaultKeyListener implements KeyListener {

    ScenePanel getScenePanel() {
        return Sokoban.getFrame().getGame().getScenePanel();
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
