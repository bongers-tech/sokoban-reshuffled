package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.GameActionEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import nl.bongers.sokoban.config.GameAction;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.event.KeyEvent;

import static nl.bongers.sokoban.config.KeyBindingConfiguration.matches;

public class ResetStateEventListener implements Subscribable {

    @Override
    public void handle(final Event event) {
        final GameActionEvent gameActionEvent = (GameActionEvent) event;
        final ScenePanel scenePanel = gameActionEvent.getScenePanel();
        final KeyEvent keyEvent = gameActionEvent.getKeyEvent();

        if (matches(GameAction.RESET, keyEvent.getKeyCode())) {
            scenePanel.getGameState().resetState();
            scenePanel.repaint();
        }
    }

    @Override
    public Class<? extends Event> subscribedEvent() {
        return GameActionEvent.class;
    }
}