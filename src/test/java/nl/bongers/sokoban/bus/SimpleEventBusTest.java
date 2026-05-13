package nl.bongers.sokoban.bus;

import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.mockito.Mockito.*;

class SimpleEventBusTest {

    private SimpleEventBus eventBus;

    @BeforeEach
    void setUp() {
        eventBus = SimpleEventBus.getBus();
        eventBus.getSubscribers().clear();
    }

    @Test
    void testPublishWithMatchingSubscriber() {
        final Subscribable subscribable = mock(Subscribable.class);
        final Event event = new Event() {};

        when(subscribable.subscribedEvents()).thenReturn(Set.of(event.getClass()));

        eventBus.register(subscribable);
        eventBus.publish(event);

        verify(subscribable).handle(event);
    }

    @Test
    void testPublishWithoutMatchingSubscriber() {
        final Subscribable subscribable = mock(Subscribable.class);
        final Event event = new Event() {};

        when(subscribable.subscribedEvents()).thenReturn(Collections.emptySet());

        eventBus.register(subscribable);
        eventBus.publish(event);

        verify(subscribable, never()).handle(event);
    }
}