package nl.bongers.sokoban.view;

import nl.bongers.sokoban.view.scene.ScenePanel;

import javax.swing.*;
import java.awt.*;

import static nl.bongers.sokoban.config.GameConfiguration.PANEL_SIZE;

public class GamePanel extends JPanel {

    private final ScenePanel scenePanel;

    public GamePanel() {
        this.scenePanel = new ScenePanel();

        setSize(PANEL_SIZE);
        setLayout(new BorderLayout());
        add(scenePanel, BorderLayout.CENTER);
    }

    public ScenePanel getScene() {
        return scenePanel;
    }
}
