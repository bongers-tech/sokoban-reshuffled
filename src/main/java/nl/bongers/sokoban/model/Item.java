package nl.bongers.sokoban.model;

import nl.bongers.sokoban.util.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.nonNull;

public abstract class Item {

    private int row;
    private int column;
    private Color color;
    private BufferedImage image;

    public Item(final int row, final int column, final Color color, final String imageFile) {
        this.row = row;
        this.column = column;

        if (nonNull(imageFile)) {
            try {
                this.image = ImageUtil.readImage(imageFile);
            } catch (IOException e) {
                this.color = color;
            }
        } else {
            this.color = color;
        }
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

    public BufferedImage getImage() {
        return image;
    }

    public Item setRow(int row) {
        this.row = row;
        return this;
    }

    public Item setColumn(int column) {
        this.column = column;
        return this;
    }

    public void setImage(final String imageFile) {
        try {
            this.image = ImageUtil.readImage(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return row == item.row && column == item.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

}
