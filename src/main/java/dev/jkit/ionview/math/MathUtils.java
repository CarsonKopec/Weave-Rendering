package dev.jkit.ionview.math;

public class MathUtils {
    public static final float PI = (float)Math.PI;
    public static final float DEG2RAD = PI / 180f;
    public static final float RAD2DEG = 180f / PI;

    public static float clamp(float v, float min, float max) {
        return v < min ? min : (v > max ? max : v);
    }

    public static float lerp(float a, float b, float t) {
        return a + (b - a) * t;
    }

    public static float map(float value, float inMin, float inMax, float outMin, float outMax) {
        return outMin + (value - inMin) * (outMax - outMin) / (inMax - inMin);
    }

    public static boolean epsilonEquals(float a, float b, float epsilon) {
        return Math.abs(a - b) <= epsilon;
    }
}
