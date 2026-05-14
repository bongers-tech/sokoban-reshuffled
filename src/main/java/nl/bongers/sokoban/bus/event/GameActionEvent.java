package nl.bongers.sokoban.bus.event;

import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.event.KeyEvent;

public class GameActionEvent extends Event {

    private final ScenePanel scenePanel;
    private final KeyEvent keyEvent;

    public GameActionEvent(final ScenePanel scenePanel, final KeyEvent keyEvent) {
        this.scenePanel = scenePanel;
        this.keyEvent = keyEvent;
    }

    public ScenePanel getScenePanel() {
        return scenePanel;
    }

    public KeyEvent getKeyEvent() {
        return keyEvent;
    }
}
