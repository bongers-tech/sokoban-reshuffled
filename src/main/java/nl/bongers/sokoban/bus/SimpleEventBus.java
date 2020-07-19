package nl.bongers.sokoban.bus;

import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.EventBus;
import nl.bongers.sokoban.bus.model.Subscribable;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public final class SimpleEventBus implements EventBus {

    private static SimpleEventBus eventBus;
    private final List<Subscribable> subscribableList = new ArrayList<>();

    private SimpleEventBus() {
        // No-args
    }

    public static SimpleEventBus getBus() {
        if (isNull(eventBus)) {
            eventBus = new SimpleEventBus();
        }
        return eventBus;
    }

    public void register(final Subscribable subscribable) {
        subscribableList.add(subscribable);
    }

    public void publish(final Event<?> event) {
        subscribableList
                .stream()
                .filter(s -> s.subscribedEvents().contains(event.getClass()))
                .forEach(s -> s.handle(event));
    }

    public List<Subscribable> getSubscribers() {
        return subscribableList;
    }
}
