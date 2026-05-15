package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MainMenuEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import nl.bongers.sokoban.view.Sokoban;

public class MainMenuEventListener implements Subscribable {

    @Override
    public void handle(final Event event) {
        System.out.println("Received event: " + event.getClass().getName());
        final Sokoban sokoban = Sokoban.getFrame();
        sokoban.showMainMenu();
    }

    @Override
    public Class<? extends Event> subscribedEvent() {
        return MainMenuEvent.class;
    }
}
