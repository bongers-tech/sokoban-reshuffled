package nl.bongers.sokoban.config;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.listener.ExitGameEventListener;
import nl.bongers.sokoban.bus.listener.GraphicEventListener;
import nl.bongers.sokoban.bus.listener.MoveEventListener;
import nl.bongers.sokoban.bus.listener.TogglePanelEventListener;
import nl.bongers.sokoban.bus.model.EventBus;

public class EventBusConfiguration implements Configuration {

    @Override
    public void processConfiguration() {
        final EventBus eventBus = SimpleEventBus.getBus();
        eventBus.register(new TogglePanelEventListener());
        eventBus.register(new ExitGameEventListener());
        eventBus.register(new MoveEventListener());
        eventBus.register(new GraphicEventListener());
    }
}
