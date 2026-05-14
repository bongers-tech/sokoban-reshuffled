package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.GameActionEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.event.KeyEvent;
import java.util.Set;

import static java.awt.event.KeyEvent.VK_Z;

public class UndoEventListener implements Subscribable {

    @Override
    public void handle(final Event event) {
        final GameActionEvent gameActionEvent = (GameActionEvent) event;
        final ScenePanel scenePanel = gameActionEvent.getScenePanel();
        final KeyEvent keyEvent = gameActionEvent.getKeyEvent();

        if (keyEvent.getKeyCode() == VK_Z) {
            scenePanel.getGameState().undo();
            scenePanel.repaint();
        }
    }

    @Override
    public Set<Class<? extends Event>> subscribedEvents() {
        return Set.of(GameActionEvent.class);
    }
}