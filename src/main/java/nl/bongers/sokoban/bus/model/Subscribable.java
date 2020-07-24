package nl.bongers.sokoban.bus.model;

import java.util.Set;

public interface Subscribable {

    void handle(final Event event);

    Set<Class<? extends Event>> subscribedEvents();

}
