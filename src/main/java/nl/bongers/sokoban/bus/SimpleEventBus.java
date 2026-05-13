package nl.bongers.sokoban.bus;

import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.EventBus;
import nl.bongers.sokoban.bus.model.Subscribable;

import java.util.ArrayList;
import java.util.List;

public final class SimpleEventBus implements EventBus {

    private static final SimpleEventBus EVENT_BUS = new SimpleEventBus();
    private final List<Subscribable> subscribableList = new ArrayList<>();

    private SimpleEventBus() {
        // No-args
    }

    public static SimpleEventBus getBus() {
        return EVENT_BUS;
    }

    public void register(final Subscribable subscribable) {
        subscribableList.add(subscribable);
    }

    public void publish(final Event event) {
        subscribableList
                .stream()
                .filter(s -> s.subscribedEvents().contains(event.getClass()))
                .forEach(s -> s.handle(event));
    }

    public List<Subscribable> getSubscribers() {
        return subscribableList;
    }
}
