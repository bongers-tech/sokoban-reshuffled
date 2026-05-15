package nl.bongers.sokoban.view.menu;

import nl.bongers.sokoban.bus.SimpleEventBus;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static nl.bongers.sokoban.util.ButtonUtil.createButton;

public class MainMenu extends Menu {

    public MainMenu() {
        super(new GridLayout(MainMenuButton.values().length + 2, 1));
    }

    @Override
    void initializeButtons() {
        Arrays.stream(MainMenuButton.values()).forEach(b -> {
            final ActionListener listener = action -> SimpleEventBus.getBus().publish(b.getEvent());
            add(createButton(b.getButtonText(), listener));
        });
    }
}
