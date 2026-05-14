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
import static org.mockito.Mockito.*;

class MoveEventListenerGoalTest {

    private Scene scene;

    private ScenePanel scenePanel;
    private GameState gameState;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        scene = SceneUtil.readScene("scene_goal");

        scenePanel = mock(ScenePanel.class);
        gameState = mock(GameState.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();

        when(scenePanel.getScene()).thenReturn(scene);
        when(scenePanel.getGameState()).thenReturn(gameState);
    }

    @Test
    void testMovePlayerUpToGoal() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(scene.player().getRow()).isEqualTo(3);
        assertThat(scene.player().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(0, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(1, 3)).isEqualTo(Tile.CELL);
        assertThat(scene.getTile(2, 3)).isEqualTo(Tile.GOAL);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(2);
        assertThat(scene.player().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(0, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(1, 3)).isEqualTo(Tile.CELL);
        assertThat(scene.getEntity(2, 3)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(1);
        assertThat(scene.player().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(0, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 3)).isInstanceOf(Player.class);
        assertThat(scene.getTile(2, 3)).isEqualTo(Tile.GOAL);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        verifyMoveActions(gameState, scenePanel, times(2));
    }

    @Test
    void testMovePlayerRightToGoal() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(3);
        assertThat(scene.player().getColumn()).isEqualTo(4);
        assertThat(scene.getTile(3, 6)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(3, 5)).isEqualTo(Tile.CELL);
        assertThat(scene.getEntity(3, 4)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(3);
        assertThat(scene.player().getColumn()).isEqualTo(5);
        assertThat(scene.getTile(3, 6)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(3, 5)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 4)).isEqualTo(Tile.GOAL);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        verifyMoveActions(gameState, scenePanel, times(2));
    }

    @Test
    void testMovePlayerDownToGoal() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(4);
        assertThat(scene.player().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(6, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(5, 3)).isEqualTo(Tile.CELL);
        assertThat(scene.getEntity(4, 3)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(5);
        assertThat(scene.player().getColumn()).isEqualTo(3);
        assertThat(scene.getTile(6, 3)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(5, 3)).isInstanceOf(Player.class);
        assertThat(scene.getTile(4, 3)).isEqualTo(Tile.GOAL);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        verifyMoveActions(gameState, scenePanel, times(2));
    }

    @Test
    void testMovePlayerLeftToGoal() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(3);
        assertThat(scene.player().getColumn()).isEqualTo(2);
        assertThat(scene.getTile(3, 0)).isEqualTo(Tile.WALL);
        assertThat(scene.getTile(3, 1)).isEqualTo(Tile.CELL);
        assertThat(scene.getEntity(3, 2)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        eventListener.handle(event);
        assertThat(scene.player().getRow()).isEqualTo(3);
        assertThat(scene.player().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(3, 0)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(3, 1)).isInstanceOf(Player.class);
        assertThat(scene.getTile(3, 2)).isEqualTo(Tile.GOAL);
        assertThat(scene.getTile(3, 3)).isEqualTo(Tile.CELL);

        verifyMoveActions(gameState, scenePanel, times(2));
    }
}