package nl.bongers.sokoban.model;

import nl.bongers.sokoban.util.SceneUtil;

public class GameState {

    private Scene scene;
    private int currentScene = 1;
    private final SceneHistory sceneHistory = new SceneHistory();

    public GameState() {
        createScene(currentScene);
    }

    public Scene getScene() {
        return scene;
    }

    private void createScene(final int currentScene) {
        scene = SceneUtil.readScene("scene_" + currentScene);
        sceneHistory.push(scene);
    }

    public void undo() {
        scene = sceneHistory.undo();
    }

    public void pushToHistory() {
        sceneHistory.push(scene);
    }

    public void checkSceneCleared() {
        if (scene.isCleared()) {
            sceneHistory.clear();
            createScene(++currentScene);
        }
    }

    public void resetState() {
        sceneHistory.clear();
        createScene(currentScene);
    }
}
