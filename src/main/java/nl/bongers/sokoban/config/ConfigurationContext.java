package nl.bongers.sokoban.config;

import java.util.List;

public final class ConfigurationContext {

    private ConfigurationContext() {
        // No-args
    }

    public static List<Configuration> getConfigurations() {
        return List.of(new EventBusConfiguration(), new KeyBindingConfiguration());
    }
}
