package nl.bongers.sokoban.bus.model;

public interface Subscribable {

    void handle(final Event event);

    Class<? extends Event> subscribedEvent();

}
