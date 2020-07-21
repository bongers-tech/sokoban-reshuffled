package nl.bongers.sokoban.view;

import nl.bongers.sokoban.view.listener.GameWindowListener;
import nl.bongers.sokoban.view.listener.GraphicKeyListener;
import nl.bongers.sokoban.view.listener.MenuKeyListener;
import nl.bongers.sokoban.view.listener.MovementKeyListener;
import nl.bongers.sokoban.view.menu.MainMenu;

import javax.swing.*;
import java.awt.*;

import static java.util.Objects.isNull;
import static nl.bongers.sokoban.config.GameConfiguration.PANEL_SIZE;

public class GameFrame extends JFrame {

    private static GameFrame gameFrame;
    private final MainMenu mainMenu = new MainMenu();
    private GamePanel gamePanel;

    private GameFrame() {
        setTitle("Sokoban Reshuffled");
        setFocusable(true);
        setUndecorated(true);

        setSize(PANEL_SIZE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(this);

        add(mainMenu, BorderLayout.CENTER);
        mainMenu.setVisible(true);
        mainMenu.requestFocus();

        setVisible(true);
    }

    public static GameFrame getFrame() {
        if (isNull(gameFrame)) {
            gameFrame = new GameFrame();
        }
        return gameFrame;
    }

    public void initializeListeners() {
        addWindowListener(new GameWindowListener());
        addKeyListener(new MovementKeyListener());
        addKeyListener(new GraphicKeyListener());
        addKeyListener(new MenuKeyListener());
    }

    public void toggleScene() {
        if (isNull(gamePanel)) {
            gamePanel = new GamePanel();
            gamePanel.setVisible(false);
            add(gamePanel, BorderLayout.CENTER);
        }
        gamePanel.setVisible(!gamePanel.isShowing());
    }

    public void toggleMenu() {
        mainMenu.setVisible(!mainMenu.isShowing());
    }

    public GamePanel getGame() {
        return gamePanel;
    }
}
