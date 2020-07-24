package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.ExitGameEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExitGameEventListener implements Subscribable {

    @Override
    public void handle(final Event event) {
        System.out.println("Received event: " + event.getClass().getName());
        System.exit(0);
    }

    @Override
    public Set<Class<? extends Event>> subscribedEvents() {
        return Stream.of(ExitGameEvent.class).collect(Collectors.toCollection(HashSet::new));
    }
}
