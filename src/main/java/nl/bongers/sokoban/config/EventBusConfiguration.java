package nl.bongers.sokoban.config;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.listener.menu.ExitGameEventListener;
import nl.bongers.sokoban.bus.listener.menu.TogglePanelEventListener;
import nl.bongers.sokoban.bus.model.EventBus;

public class EventBusConfiguration implements Configuration {

    @Override
    public void processConfiguration() {
        final EventBus eventBus = SimpleEventBus.getBus();
        eventBus.register(new TogglePanelEventListener());
        eventBus.register(new ExitGameEventListener());
    }
}
