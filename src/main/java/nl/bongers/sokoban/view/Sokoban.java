package nl.bongers.sokoban.view;

import nl.bongers.sokoban.view.listener.*;
import nl.bongers.sokoban.view.menu.MainMenu;
import nl.bongers.sokoban.view.menu.OptionsMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;

import static java.util.Objects.isNull;
import static nl.bongers.sokoban.config.GameConfiguration.PANEL_SIZE;

public class Sokoban extends JFrame {

    private static final Sokoban SOKOBAN = new Sokoban();

    private final MainMenu mainMenu = new MainMenu();
    private final OptionsMenu optionsMenu = new OptionsMenu();
    private final JPanel screens = new JPanel(new CardLayout());

    private GamePanel gamePanel;

    private Sokoban() {
        setTitle("Sokoban Reshuffled");
        setFocusable(true);
        setUndecorated(true);

        setSize(PANEL_SIZE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(this);

        initializeKeyListeners(mainMenu, List.of(new MenuKeyListener()));
        initializeKeyListeners(optionsMenu, List.of(new MenuKeyListener()));

        screens.add(mainMenu, "mainMenu");
        screens.add(optionsMenu, "optionsMenu");
        add(screens, BorderLayout.CENTER);

        showMainMenu();
        setVisible(true);
    }

    public static Sokoban getFrame() {
        return SOKOBAN;
    }

    public GamePanel getGame() {
        return gamePanel;
    }

    public void initialize() {
        addWindowListener(new GameWindowListener());
    }

    public void showMainMenu() {
        final CardLayout layout = (CardLayout) screens.getLayout();
        layout.show(screens, "mainMenu");
        mainMenu.requestFocusInWindow();
    }

    public void showOptionsMenu() {
        final CardLayout layout = (CardLayout) screens.getLayout();
        layout.show(screens, "optionsMenu");
        optionsMenu.requestFocusInWindow();
    }

    public void showGamePanel() {
        if (isNull(gamePanel)) {
            createGamePanel();
        }
        final CardLayout layout = (CardLayout) screens.getLayout();
        layout.show(screens, "gamePanel");
        gamePanel.requestFocusInWindow();
    }

    private void createGamePanel() {
        gamePanel = new GamePanel();
        initializeMouseListeners(gamePanel, List.of(new DefaultMouseListener()));
        initializeKeyListeners(gamePanel, List.of(new MovementKeyListener(), new GameActionKeyListener(), new MenuKeyListener()));
        screens.add(gamePanel, "gamePanel");
    }

    private void initializeKeyListeners(final JPanel panel, final List<KeyListener> listeners) {
        listeners.forEach(panel::addKeyListener);
    }

    private void initializeMouseListeners(final JPanel panel, final List<MouseListener> listeners) {
        listeners.forEach(panel::addMouseListener);
    }
}
