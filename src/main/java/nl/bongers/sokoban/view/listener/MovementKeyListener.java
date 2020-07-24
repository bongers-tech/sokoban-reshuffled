package nl.bongers.sokoban.view.listener;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.event.MoveEvent;

import java.awt.event.KeyEvent;

public class MovementKeyListener extends DefaultKeyListener {

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        SimpleEventBus.getBus().publish(new MoveEvent(getScenePanel(), keyEvent));
    }
}
