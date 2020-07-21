package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.view.GameFrame;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

abstract class DefaultKeyListener implements KeyListener {

    ScenePanel getScenePanel() {
        return GameFrame.getFrame().getGame().getScenePanel();
    }

    Player getPlayer() {
        return GameFrame.getFrame().getGame().getScenePanel().getPlayer();
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
