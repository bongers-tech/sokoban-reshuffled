package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.OptionsMenuEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import nl.bongers.sokoban.view.Sokoban;

public class OptionsEventListener implements Subscribable {

    @Override
    public void handle(final Event event) {
        System.out.println("Received event: " + event.getClass().getName());
        final Sokoban sokoban = Sokoban.getFrame();
        sokoban.showOptionsMenu();
    }

    @Override
    public Class<? extends Event> subscribedEvent() {
        return OptionsMenuEvent.class;
    }
}
