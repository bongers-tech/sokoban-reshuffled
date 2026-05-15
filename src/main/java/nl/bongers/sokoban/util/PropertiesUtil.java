package nl.bongers.sokoban.util;

import nl.bongers.sokoban.config.GameAction;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.Map;
import java.util.Properties;

import static java.util.Objects.nonNull;
import static nl.bongers.sokoban.config.KeyBindingConfiguration.getKeyCode;

public final class PropertiesUtil {

    private PropertiesUtil() {
        // No-args
    }

    public static void saveProperties(final Path configDirectory, final Path configFile) {
        final Properties properties = new Properties();

        for (final GameAction action : GameAction.values()) {
            properties.setProperty(action.name(), String.valueOf(getKeyCode(action)));
        }

        try {
            Files.createDirectories(configDirectory);

            try (OutputStream outputStream = Files.newOutputStream(configFile)) {
                properties.store(outputStream, "Sokoban Reshuffled key bindings");
            }

        } catch (final IOException exception) {
            throw new IllegalStateException("Could not save key bindings", exception);
        }
    }

    public static Map<GameAction, Integer> loadProperties(final Path configFile) {
        final Properties properties = new Properties();

        final Map<GameAction, Integer> keyBindings = new EnumMap<>(GameAction.class);
        try (final InputStream inputStream = Files.newInputStream(configFile)) {
            properties.load(inputStream);

            for (final GameAction action : GameAction.values()) {
                final String value = properties.getProperty(action.name());

                if (nonNull(value)) {
                    keyBindings.put(action, Integer.parseInt(value));
                }
            }
        } catch (final IOException | NumberFormatException exception) {
            throw new IllegalStateException("Could not load key bindings", exception);
        }

        return keyBindings;
    }
}