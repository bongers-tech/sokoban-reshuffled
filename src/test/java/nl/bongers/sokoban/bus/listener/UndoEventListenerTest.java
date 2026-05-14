package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.GameActionEvent;
import nl.bongers.sokoban.model.GameState;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;

class UndoEventListenerTest {

    private UndoEventListener undoEventListener;

    @BeforeEach
    void setup() {
        undoEventListener = new UndoEventListener();
    }

    @Test
    void testUndoHandler() {
        final ScenePanel scenePanel = mock(ScenePanel.class);
        final GameState gameState = mock(GameState.class);

        final KeyEvent keyEvent = new KeyEvent(mock(ScenePanel.class), 0, 0, 0, KeyEvent.VK_Z, 'Z');
        final GameActionEvent event = mock(GameActionEvent.class);

        when(scenePanel.getGameState()).thenReturn(gameState);
        when(event.getScenePanel()).thenReturn(scenePanel);
        when(event.getKeyEvent()).thenReturn(keyEvent);

        undoEventListener.handle(event);

        verify(gameState).undo();
        verify(scenePanel).repaint();
    }

    @Test
    void testUndoHandlerDifferentKey() {
        final ScenePanel scenePanel = mock(ScenePanel.class);
        final GameState gameState = mock(GameState.class);

        final KeyEvent keyEvent = new KeyEvent(mock(ScenePanel.class), 0, 0, 0, KeyEvent.VK_A, 'A');
        final GameActionEvent event = mock(GameActionEvent.class);

        when(scenePanel.getGameState()).thenReturn(gameState);
        when(event.getScenePanel()).thenReturn(scenePanel);
        when(event.getKeyEvent()).thenReturn(keyEvent);

        undoEventListener.handle(event);

        verifyNoInteractions(scenePanel);
    }
}