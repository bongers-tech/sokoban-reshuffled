package nl.bongers.sokoban.view.adapter;

import nl.bongers.sokoban.config.GameAction;
import nl.bongers.sokoban.config.KeyBindingConfiguration;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static nl.bongers.sokoban.config.KeyBindingConfiguration.getKeyText;

public class KeyBindingAdapter extends KeyAdapter {

    private final GameAction action;
    private final JButton button;

    public KeyBindingAdapter(final GameAction action, final JButton button) {
        this.action = action;
        this.button = button;
    }

    @Override
    public void keyPressed(final KeyEvent keyEvent) {
        KeyBindingConfiguration.setKeyCode(action, keyEvent.getKeyCode());
        button.setText(getKeyText(action));
        button.removeKeyListener(this);
    }
}
