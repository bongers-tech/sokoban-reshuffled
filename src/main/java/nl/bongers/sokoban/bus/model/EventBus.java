package nl.bongers.sokoban.bus.model;


import java.util.List;

public interface EventBus {

    void register(final Subscribable subscribable);

    void publish(final Event<?> event);

    List<Subscribable> getSubscribers();

}
