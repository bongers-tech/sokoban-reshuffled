package nl.bongers.sokoban.config;

import java.util.Arrays;
import java.util.List;

public final class ConfigurationContext {

    private ConfigurationContext() {
        // No-args
    }

    public static List<Configuration> getConfigurations() {
        return Arrays.asList(
                new EventBusConfiguration()
        );
    }
}
