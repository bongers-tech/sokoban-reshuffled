package nl.bongers.sokoban;

import nl.bongers.sokoban.config.Configuration;
import nl.bongers.sokoban.config.ConfigurationContext;
import nl.bongers.sokoban.view.Sokoban;

public class Application {

    public static void main(final String... args) {
        ConfigurationContext.getConfigurations().forEach(Configuration::processConfiguration);



        final Sokoban sokoban = Sokoban.getFrame();
        sokoban.initializeListeners();
    }
}
