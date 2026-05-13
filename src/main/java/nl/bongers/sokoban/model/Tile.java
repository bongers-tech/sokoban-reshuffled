package nl.bongers.sokoban.model;

public enum Tile implements Drawable {

    CELL(null),
    WALL("wall"),
    GOAL("goal"),
    ACTUAL("actual"),
    DONE("done");

    private final String imageName;

    Tile(final String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String getImageName() {
        return imageName;
    }
}
