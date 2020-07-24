package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.view.scene.ScenePanel;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.awt.event.KeyEvent.*;

public class GraphicEventListener implements Subscribable {

    @Override
    public void handle(final Event event) {
        final MoveEvent moveEvent = (MoveEvent) event;
        final KeyEvent keyEvent = moveEvent.getKeyEvent();
        final ScenePanel scenePanel = moveEvent.getScenePanel();
        final Player player = scenePanel.getScene().getPlayer();

        switch (keyEvent.getKeyCode()) {
            case VK_W:
            case VK_KP_UP:
                player.setImage("player_up");
                break;
            case VK_D:
            case VK_KP_RIGHT:
                player.setImage("player_right");
                break;
            case VK_S:
            case VK_KP_DOWN:
                player.setImage("player_down");
                break;
            case VK_A:
            case VK_KP_LEFT:
                player.setImage("player_left");
                break;
            default:
                break;
        }

        scenePanel.repaint();
    }

    @Override
    public Set<Class<? extends Event>> subscribedEvents() {
        return Stream.of(MoveEvent.class).collect(Collectors.toCollection(HashSet::new));
    }
}
