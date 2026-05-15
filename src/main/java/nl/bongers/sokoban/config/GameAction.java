package nl.bongers.sokoban.config;

import java.awt.event.KeyEvent;

public enum GameAction {

    UNDO("Undo", KeyEvent.VK_Z),
    RESET("Reset", KeyEvent.VK_R);

    private final String displayName;
    private final int defaultKeyCode;

    GameAction(final String displayName, final int defaultKeyCode) {
        this.displayName = displayName;
        this.defaultKeyCode = defaultKeyCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getDefaultKeyCode() {
        return defaultKeyCode;
    }
}