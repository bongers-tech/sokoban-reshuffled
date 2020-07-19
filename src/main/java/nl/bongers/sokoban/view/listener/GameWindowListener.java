package nl.bongers.sokoban.view.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindowListener extends WindowAdapter {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println("Window state changed");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing");
        shutdown();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window deactivated");
    }

    @Override
    public void windowClosed(final WindowEvent e) {
        System.out.println("Window closed");
        shutdown();
    }

    private void shutdown() {
        System.exit(0);
    }
}
