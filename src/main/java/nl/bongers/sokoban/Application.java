package nl.bongers.sokoban;

import nl.bongers.sokoban.config.Configuration;
import nl.bongers.sokoban.config.ConfigurationContext;
import nl.bongers.sokoban.view.GameFrame;

public class Application {

    public static void main(final String... args) {
        ConfigurationContext.getConfigurations().forEach(Configuration::processConfiguration);
        final GameFrame gameFrame = GameFrame.getFrame();
        gameFrame.initializeListeners();
    }
}
