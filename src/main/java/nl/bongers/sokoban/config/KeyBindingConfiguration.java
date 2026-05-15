package nl.bongers.sokoban.config;

import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static nl.bongers.sokoban.util.PropertiesUtil.loadProperties;
import static nl.bongers.sokoban.util.PropertiesUtil.saveProperties;

public class KeyBindingConfiguration implements Configuration {

    private static final Path CONFIG_DIRECTORY = Path.of(System.getProperty("user.home"), ".sokoban-reshuffled");
    private static final Path CONFIG_FILE = CONFIG_DIRECTORY.resolve("keybindings.properties");
    private static final Map<GameAction, Integer> KEY_BINDINGS = new EnumMap<>(GameAction.class);

    @Override
    public void processConfiguration() {
        setDefaults();
    }

    public static int getKeyCode(final GameAction action) {
        return KEY_BINDINGS.getOrDefault(action, action.getDefaultKeyCode());
    }

    public static void setKeyCode(final GameAction action, final int keyCode) {
        KEY_BINDINGS.put(action, keyCode);
        saveProperties(CONFIG_DIRECTORY, CONFIG_FILE);
    }

    public static String getKeyText(final GameAction action) {
        return KeyEvent.getKeyText(getKeyCode(action));
    }

    public static boolean matches(final GameAction action, final int keyCode) {
        return getKeyCode(action) == keyCode;
    }

    public static GameAction findActionByKeyCode(final int keyCode) {
        return Arrays.stream(GameAction.values())
                .filter(action -> matches(action, keyCode))
                .findFirst()
                .orElse(null);
    }

    private void setDefaults() {
        if (Files.exists(CONFIG_DIRECTORY)) {
            KEY_BINDINGS.putAll(loadProperties(CONFIG_FILE));
        } else {
            Arrays.stream(GameAction.values()).forEach(action -> KEY_BINDINGS.put(action, action.getDefaultKeyCode()));
            saveProperties(CONFIG_DIRECTORY, CONFIG_FILE);
        }
    }
}