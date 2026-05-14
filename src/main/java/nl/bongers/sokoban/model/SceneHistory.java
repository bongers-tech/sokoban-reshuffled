package nl.bongers.sokoban.model;

import nl.bongers.sokoban.util.CopyUtil;

import java.util.ArrayDeque;
import java.util.Deque;

public class SceneHistory {

    private final Deque<Scene> scenes = new ArrayDeque<>();

    public void push(final Scene scene) {
        scenes.push(CopyUtil.copy(scene));
    }

    public Scene undo() {
        if (scenes.size() > 1) {
            scenes.pop();
        }
        return CopyUtil.copy(scenes.peek());
    }

    public void clear() {
        scenes.clear();
    }
}
