package nl.bongers.sokoban.config;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.listener.*;
import nl.bongers.sokoban.bus.model.EventBus;

public class EventBusConfiguration implements Configuration {

    @Override
    public void processConfiguration() {
        final EventBus eventBus = SimpleEventBus.getBus();
        eventBus.register(new MainMenuEventListener());
        eventBus.register(new NewGameEventListener());
        eventBus.register(new ExitGameEventListener());
        eventBus.register(new MoveEventListener());
        eventBus.register(new GraphicEventListener());
        eventBus.register(new UndoEventListener());
        eventBus.register(new ResetStateEventListener());
        eventBus.register(new OptionsEventListener());
    }
}
