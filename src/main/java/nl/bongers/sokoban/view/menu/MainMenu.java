package nl.bongers.sokoban.view.menu;

import nl.bongers.sokoban.bus.SimpleEventBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static java.awt.Label.LEFT;
import static nl.bongers.sokoban.util.ButtonUtil.createButton;

public class MainMenu extends JPanel {

    public MainMenu() {
        super(new GridLayout(MainMenuButton.values().length + 2, 1));
        initializeLabel();
        initializeButtons();
        initializeCredits();
    }

    private void initializeLabel() {
        final Label label = new Label("SOKOBAN RESHUFFLED");
        label.setBackground(Color.LIGHT_GRAY);
        label.setAlignment(Label.CENTER);
        add(label);
    }

    private void initializeButtons() {
        Arrays.stream(MainMenuButton.values()).forEach(b -> {
            final ActionListener listener = action -> SimpleEventBus.getBus().publish(b.getEvent());
            add(createButton(b.getButtonText(), listener));
        });
    }

    private void initializeCredits() {
        final Label label = new Label("2020 - JAN BONGERS");
        label.setForeground(Color.WHITE);
        label.setBackground(Color.GRAY);
        label.setAlignment(Label.CENTER);
        add(label);
    }
}
