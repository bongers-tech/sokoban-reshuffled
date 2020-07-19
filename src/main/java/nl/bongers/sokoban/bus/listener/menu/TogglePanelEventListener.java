package nl.bongers.sokoban.bus.listener.menu;

import nl.bongers.sokoban.bus.event.MainMenuEvent;
import nl.bongers.sokoban.bus.event.NewGameEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.model.Subscribable;
import nl.bongers.sokoban.view.GameFrame;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TogglePanelEventListener implements Subscribable {

    @Override
    public void handle(final Event<?> event) {
        System.out.println("Received event: " + event.getClass().getName());
        final GameFrame gameFrame = GameFrame.getFrame();
        gameFrame.toggleMenu();
        gameFrame.toggleScene();
    }

    @Override
    public Set<Class<? extends Event<?>>> subscribedEvents() {
        return Stream.of(NewGameEvent.class, MainMenuEvent.class).collect(Collectors.toCollection(HashSet::new));
    }
}
