package nl.bongers.sokoban.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.isNull;
import static nl.bongers.sokoban.config.GameConfiguration.POINTS_PER_SQUARE;

public class ImageUtil {

    private static final ImageUtil IMAGE_UTIL = new ImageUtil();
    private final ConcurrentHashMap<String, BufferedImage> assetsMap;

    private ImageUtil() {
        this.assetsMap = new ConcurrentHashMap<>();
    }

    public static ImageUtil getInstance() {
        return IMAGE_UTIL;
    }

    public BufferedImage readImage(final String imageName) {
        BufferedImage image = assetsMap.get(imageName);
        if (isNull(image)) {
            try {
                image = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("assets/default/" + imageName + ".png")));
                image = resize(image);
                assetsMap.put(imageName, image);
            } catch (IOException e) {
                System.out.println("Error reading image: " + e.getMessage());
            }
        }
        return image;
    }

    private BufferedImage resize(final BufferedImage image) {
        final Image tmp = image.getScaledInstance(POINTS_PER_SQUARE, POINTS_PER_SQUARE, Image.SCALE_SMOOTH);
        final BufferedImage resized = new BufferedImage(POINTS_PER_SQUARE, POINTS_PER_SQUARE, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
