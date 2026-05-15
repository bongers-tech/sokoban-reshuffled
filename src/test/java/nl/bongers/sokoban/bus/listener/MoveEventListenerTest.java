package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.bus.model.Event;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveEventListenerTest {

    @Test
    void testSubscribedEvents() {
        final MoveEventListener eventListener = new MoveEventListener();
        final Class<? extends Event> subscribedEvent = eventListener.subscribedEvent();
        assertThat(subscribedEvent).isEqualTo(MoveEvent.class);
    }
}
