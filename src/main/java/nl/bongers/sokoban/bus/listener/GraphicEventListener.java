package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import nl.bongers.sokoban.model.Direction;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.event.KeyEvent;
import java.util.Set;

import static java.awt.event.KeyEvent.*;

public class GraphicEventListener implements Subscribable {

    @Override
    public void handle(final Event event) {
        final MoveEvent moveEvent = (MoveEvent) event;
        final KeyEvent keyEvent = moveEvent.getKeyEvent();
        final ScenePanel scenePanel = moveEvent.getScenePanel();
        final Player player = scenePanel.getScene().getPlayer();

        switch (keyEvent.getKeyCode()) {
            case VK_W, VK_KP_UP -> player.setDirection(Direction.UP);
            case VK_D, VK_KP_RIGHT -> player.setDirection(Direction.RIGHT);
            case VK_S, VK_KP_DOWN -> player.setDirection(Direction.DOWN);
            case VK_A, VK_KP_LEFT -> player.setDirection(Direction.LEFT);
        }

        scenePanel.repaint();
    }

    @Override
    public Set<Class<? extends Event>> subscribedEvents() {
        return Set.of(MoveEvent.class);
    }
}
