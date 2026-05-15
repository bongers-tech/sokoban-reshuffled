package nl.bongers.sokoban.view.menu;

import nl.bongers.sokoban.bus.SimpleEventBus;
import nl.bongers.sokoban.bus.event.MainMenuEvent;
import nl.bongers.sokoban.config.GameAction;
import nl.bongers.sokoban.util.ButtonUtil;
import nl.bongers.sokoban.view.adapter.KeyBindingAdapter;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;
import static nl.bongers.sokoban.config.KeyBindingConfiguration.getKeyText;

public class OptionsMenu extends Menu {

    public OptionsMenu() {
        super(new GridBagLayout());
        initializeLabel();
        initializeButtons();
        initializeCredits();
    }

    @Override
    void initializeLabel() {
        add(label(), constraints(0, 0, 2));
    }

    @Override
    void initializeButtons() {
        int row = 1;
        for (final GameAction action : GameAction.values()) {
            add(new JLabel(action.getDisplayName(), CENTER), constraints(0, row, 1));

            final JButton button = new JButton(getKeyText(action));
            button.addActionListener(event -> waitForKeyPress(action, button));

            add(button, constraints(1, row, 1));
            row++;
        }
        add(ButtonUtil.createButton("Back", action -> SimpleEventBus.getBus().publish(new MainMenuEvent())), constraints(0, row, 2));
    }

    @Override
    void initializeCredits() {
        add(credits(), constraints(0, GameAction.values().length + 2, 2));
    }

    private GridBagConstraints constraints(final int x, final int y, final int width) {
        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        return constraints;
    }

    private void waitForKeyPress(final GameAction action, final JButton button) {
        button.setText("Press a key...");
        button.requestFocusInWindow();
        button.addKeyListener(new KeyBindingAdapter(action, button));
    }
}