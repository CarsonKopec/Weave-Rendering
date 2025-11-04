package dev.jkit.ionview.math;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static float range(float min, float max) {
        return min + random.nextFloat() * (max - min);
    }

    public static int range(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static Vector2 randomDirection2D() {
        float angle = (float)(random.nextFloat() * 2 * Math.PI);
        return new Vector2((float)Math.cos(angle), (float)Math.sin(angle));
    }
}
