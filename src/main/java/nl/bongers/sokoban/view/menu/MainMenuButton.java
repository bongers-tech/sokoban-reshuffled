package nl.bongers.sokoban.view.menu;

import nl.bongers.sokoban.bus.event.PlaceholderEvent;
import nl.bongers.sokoban.bus.model.Event;
import nl.bongers.sokoban.bus.event.ExitGameEvent;
import nl.bongers.sokoban.bus.event.NewGameEvent;

public enum MainMenuButton {

    NEW_GAME("New game", new NewGameEvent()),
    OPTIONS("Options", new PlaceholderEvent()),
    EXIT_GAME("Exit", new ExitGameEvent());

    private final String buttonText;
    private final Event<?> event;

    MainMenuButton(final String buttonText, final Event<?> event) {
        this.buttonText = buttonText;
        this.event = event;
    }

    public String getButtonText() {
        return buttonText;
    }

    public Event<?> getEvent() {
        return event;
    }
}
