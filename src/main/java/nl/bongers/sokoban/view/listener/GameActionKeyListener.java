package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.event.GameActionEvent;

import java.awt.event.KeyEvent;
import java.util.Arrays;

import static java.awt.event.KeyEvent.VK_R;
import static java.awt.event.KeyEvent.VK_Z;

public class GameActionKeyListener extends DefaultKeyListener {

    private static final int[] ACTION_KEY_EVENTS = {VK_Z, VK_R};

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();
        if (Arrays.stream(ACTION_KEY_EVENTS).anyMatch(key -> key == keyCode)) {
            SimpleEventBus.getBus().publish(new GameActionEvent(getScenePanel(), keyEvent));
        }
    }
}
