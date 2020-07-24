package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.bus.model.Event;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MoveEventListenerTest {

    @Test
    void testSubscribedEvents() {
        final MoveEventListener eventListener = new MoveEventListener();
        final Set<Class<? extends Event>> subscribedEvents = eventListener.subscribedEvents();
        assertThat(subscribedEvents)
                .hasSize(1)
                .containsExactly(MoveEvent.class);
    }
}
