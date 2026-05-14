package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.GameActionEvent;
import nl.bongers.sokoban.model.GameState;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;

class ResetStateEventListenerTest {

    private ResetStateEventListener resetStateEventListener;

    @BeforeEach
    void setup() {
        resetStateEventListener = new ResetStateEventListener();
    }

    @Test
    void testResetStateHandler() {
        final ScenePanel scenePanel = mock(ScenePanel.class);
        final GameState gameState = mock(GameState.class);

        final KeyEvent keyEvent = new KeyEvent(mock(ScenePanel.class), 0, 0, 0, KeyEvent.VK_R, 'R');
        final GameActionEvent event = mock(GameActionEvent.class);

        when(scenePanel.getGameState()).thenReturn(gameState);
        when(event.getScenePanel()).thenReturn(scenePanel);
        when(event.getKeyEvent()).thenReturn(keyEvent);

        resetStateEventListener.handle(event);

        verify(gameState).resetState();
        verify(scenePanel).repaint();
    }

    @Test
    void testResetStateHandlerDifferentKey() {
        final ScenePanel scenePanel = mock(ScenePanel.class);
        final GameState gameState = mock(GameState.class);

        final KeyEvent keyEvent = new KeyEvent(mock(ScenePanel.class), 0, 0, 0, KeyEvent.VK_A, 'A');
        final GameActionEvent event = mock(GameActionEvent.class);

        when(scenePanel.getGameState()).thenReturn(gameState);
        when(event.getScenePanel()).thenReturn(scenePanel);
        when(event.getKeyEvent()).thenReturn(keyEvent);

        resetStateEventListener.handle(event);

        verify(gameState, never()).resetState();
        verifyNoInteractions(scenePanel);
    }
}