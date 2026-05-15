package nl.bongers.sokoban.bus;

import nl.bongers.sokoban.bus.event.ExitGameEvent;
import nl.bongers.sokoban.bus.event.NewGameEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        final Event event = new NewGameEvent();

        doReturn(NewGameEvent.class).when(subscribable).subscribedEvent();

        eventBus.register(subscribable);
        eventBus.publish(event);

        verify(subscribable).handle(event);
    }

    @Test
    void testPublishWithoutMatchingSubscriber() {
        final Subscribable subscribable = mock(Subscribable.class);
        final Event event = new NewGameEvent();

        doReturn(ExitGameEvent.class).when(subscribable).subscribedEvent();

        eventBus.register(subscribable);
        eventBus.publish(event);

        verify(subscribable, never()).handle(event);
    }
}