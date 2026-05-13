package nl.bongers.sokoban.model;

import java.awt.*;
import java.util.Objects;

public abstract class Entity implements Drawable {

    private int row;
    private int column;
    private final Color color;
    private final String imageName;

    public Entity(final int row, final int column, final Color color, final String imageName) {
        this.row = row;
        this.column = column;
        this.color = color;
        this.imageName = imageName;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String getImageName() {
        return imageName;
    }

    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return row == entity.row && column == entity.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
