package nl.bongers.sokoban.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static nl.bongers.sokoban.config.GameConfiguration.POINTS_PER_SQUARE;

public final class ImageUtil {

    private ImageUtil() {
        // No-args
    }

    public static BufferedImage readImage(final String imageFile) throws IOException {
        final BufferedImage image = ImageIO.read(ClassLoader.getSystemClassLoader().getResource("assets/default/" + imageFile + ".png"));
        return resize(image);
    }

    private static BufferedImage resize(final BufferedImage image) {
        final Image tmp = image.getScaledInstance(POINTS_PER_SQUARE, POINTS_PER_SQUARE, Image.SCALE_SMOOTH);
        final BufferedImage resized = new BufferedImage(POINTS_PER_SQUARE, POINTS_PER_SQUARE, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
