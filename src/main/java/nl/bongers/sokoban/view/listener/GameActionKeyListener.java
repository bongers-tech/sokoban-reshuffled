package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.event.GameActionEvent;

import java.awt.event.KeyEvent;

import static java.util.Objects.nonNull;
import static nl.bongers.sokoban.config.KeyBindingConfiguration.findActionByKeyCode;

public class GameActionKeyListener extends DefaultKeyListener {

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();
        if (nonNull(findActionByKeyCode(keyCode))) {
            SimpleEventBus.getBus().publish(new GameActionEvent(getScenePanel(), keyEvent));
        }
    }
}