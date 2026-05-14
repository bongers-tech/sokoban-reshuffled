package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.model.GameState;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.model.Scene;
import nl.bongers.sokoban.model.Tile;
import nl.bongers.sokoban.util.SceneUtil;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static nl.bongers.sokoban.bus.testutil.Verifications.verifyMoveActions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoveEventListenerWallTest {

    private Scene scene;

    private ScenePanel scenePanel;
    private GameState gameState;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        scene = SceneUtil.readScene("scene_wall");

        scenePanel = mock(ScenePanel.class);
        gameState = mock(GameState.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();

        when(scenePanel.getScene()).thenReturn(scene);
        when(scenePanel.getGameState()).thenReturn(gameState);
    }

    @Test
    void testMovePlayerUpToWall() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(scene.player().getRow()).isEqualTo(1);
        assertThat(scene.player().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(scene.player().getRow()).isEqualTo(1);
        assertThat(scene.player().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);

        verifyMoveActions(gameState, scenePanel);
    }

    @Test
    void testMovePlayerRightToWall() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(1);
        assertThat(scene.player().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);

        verifyMoveActions(gameState, scenePanel);
    }

    @Test
    void testMovePlayerDownToWall() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(1);
        assertThat(scene.player().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);

        verifyMoveActions(gameState, scenePanel);
    }

    @Test
    void testMovePlayerLeftToWall() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(1);
        assertThat(scene.player().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);

        verifyMoveActions(gameState, scenePanel);
    }
}