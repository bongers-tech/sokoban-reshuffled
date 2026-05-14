package nl.bongers.sokoban.bus.testutil;

import nl.bongers.sokoban.model.GameState;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.mockito.verification.VerificationMode;

import static org.mockito.Mockito.verify;

public final class Verifications {

    private Verifications() {
        // No-args
    }

    public static void verifyMoveActions(final GameState gameState, final ScenePanel scenePanel) {
        verify(gameState).pushToHistory();
        verify(gameState).checkSceneCleared();
        verify(scenePanel).repaint();
    }

    public static void verifyMoveActions(final GameState gameState, final ScenePanel scenePanel, final VerificationMode times) {
        verify(gameState, times).pushToHistory();
        verify(gameState, times).checkSceneCleared();
        verify(scenePanel, times).repaint();
    }
}