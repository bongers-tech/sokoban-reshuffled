package nl.bongers.sokoban.view.menu;

import javax.swing.*;
import java.awt.*;

public abstract class Menu extends JPanel {

    public Menu(final LayoutManager layout) {
        super(layout);
        initializeLabel();
        initializeButtons();
        initializeCredits();
    }

    abstract void initializeButtons();

    void initializeLabel() {
        add(label());
    }

    void initializeCredits() {
        add(credits());
    }

    Label label() {
        final Label label = new Label("SOKOBAN RESHUFFLED");
        label.setBackground(Color.LIGHT_GRAY);
        label.setAlignment(Label.CENTER);
        return label;
    }

    Label credits() {
        final Label label = new Label("2026 - JAN BONGERS");
        label.setForeground(Color.WHITE);
        label.setBackground(Color.GRAY);
        label.setAlignment(Label.CENTER);
        return label;
    }
}
