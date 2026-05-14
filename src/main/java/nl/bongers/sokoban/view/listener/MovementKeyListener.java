package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.event.MoveEvent;

import java.awt.event.KeyEvent;
import java.util.Arrays;

import static java.awt.event.KeyEvent.*;

public class MovementKeyListener extends DefaultKeyListener {

    private static final int[] MOVEMENT_KEY_EVENTS = {VK_W, VK_A, VK_S, VK_D, VK_KP_UP, VK_KP_LEFT, VK_KP_DOWN, VK_KP_RIGHT};
    
    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();
        if (Arrays.stream(MOVEMENT_KEY_EVENTS).anyMatch(key -> key == keyCode)) {
            SimpleEventBus.getBus().publish(new MoveEvent(getScenePanel(), keyEvent));
        }
    }
}
