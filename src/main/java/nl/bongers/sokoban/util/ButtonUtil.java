package nl.bongers.sokoban.util;

import javax.swing.*;
import java.awt.event.ActionListener;

public final class ButtonUtil {

    private ButtonUtil() {
        // No-args
    }

    public static JButton createButton(final String buttonText, final ActionListener aListener) {
        final JButton button = new JButton();
        button.setText(buttonText);
        button.addActionListener(aListener);
        return button;
    }
}
