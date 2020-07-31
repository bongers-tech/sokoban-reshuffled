package nl.bongers.sokoban.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.isNull;
import static nl.bongers.sokoban.config.GameConfiguration.POINTS_PER_SQUARE;

public class ImageUtil {

    private static ImageUtil util;
    private final Map<String, BufferedImage> assetsMap;

    private ImageUtil() {
        this.assetsMap = new HashMap<>();
    }

    public static ImageUtil getInstance() {
        if (isNull(util)) {
            util = new ImageUtil();
        }
        return util;
    }

    public BufferedImage readImage(final String imageFile) throws IOException {
        BufferedImage image = assetsMap.get(imageFile);
        if (isNull(image)) {
            image = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("assets/default/" + imageFile + ".png")));
            image = resize(image);
            assetsMap.put(imageFile, image);
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
