package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.model.Scene;
import nl.bongers.sokoban.model.Tile;
import nl.bongers.sokoban.util.SceneUtil;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoveEventListenerWallTest {

    private Scene scene;

    private ScenePanel scenePanel;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        scene = SceneUtil.readScene("scene_wall");

        scenePanel = mock(ScenePanel.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();
    }

    @Test
    void testMovePlayerUpToWall() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(scene.getPlayer().getRow()).isEqualTo(1);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(scene.getPlayer().getRow()).isEqualTo(1);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerRightToWall() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(1);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerDownToWall() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(1);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerLeftToWall() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        eventListener.handle(event);
        assertThat(scene.getPlayer().getRow()).isEqualTo(1);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(1);
        assertThat(scene.getTile(0, 1)).isEqualTo(Tile.WALL);
        assertThat(scene.getEntity(1, 1)).isInstanceOf(Player.class);
    }
}
