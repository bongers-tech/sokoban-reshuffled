package nl.bongers.sokoban.bus.listener;

import nl.bongers.sokoban.bus.event.MoveEvent;
import nl.bongers.sokoban.model.Box;
import nl.bongers.sokoban.model.Player;
import nl.bongers.sokoban.model.Scene;
import nl.bongers.sokoban.util.SceneUtil;
import nl.bongers.sokoban.view.scene.ScenePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoveEventListenerBoxAndBoxTest {

    private Scene scene;

    private ScenePanel scenePanel;
    private KeyEvent keyEvent;
    private MoveEventListener eventListener;

    @BeforeEach
    void setUp() {
        scene = SceneUtil.readScene("scene_box_box");

        scenePanel = mock(ScenePanel.class);
        keyEvent = mock(KeyEvent.class);
        eventListener = new MoveEventListener();
    }

    @Test
    void testMovePlayerUpToBoxAndBoxToBox() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_W);

        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getEntity(1, 3)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(2, 3)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getEntity(1, 3)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(2, 3)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerRightToBoxAndBoxToBox() {
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_D);

        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getEntity(3, 5)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 4)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getEntity(3, 5)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 4)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerDownToBoxAndBoxToBox() {
        final Scene scene = SceneUtil.readScene("scene_box_box");
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_S);

        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getEntity(5, 3)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(4, 3)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getEntity(5, 3)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(4, 3)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);
    }

    @Test
    void testMovePlayerLeftToBoxAndBoxToBox() {
        final Scene scene = SceneUtil.readScene("scene_box_box");
        final MoveEvent event = new MoveEvent(scenePanel, keyEvent);

        when(scenePanel.getScene()).thenReturn(scene);
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_A);

        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getEntity(3, 1)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 2)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);

        eventListener.handle(event);

        assertThat(scene.getPlayer().getRow()).isEqualTo(3);
        assertThat(scene.getPlayer().getColumn()).isEqualTo(3);
        assertThat(scene.getEntity(3, 1)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 2)).isInstanceOf(Box.class);
        assertThat(scene.getEntity(3, 3)).isInstanceOf(Player.class);
    }
}
