package dev.jkit.ionview.math;

public class Interpolation {
    public static float linear(float t) { return t; }
    public static float smoothstep(float t) { return t * t * (3 - 2 * t); }
    public static float easeIn(float t) { return t * t; }
    public static float easeOut(float t) { return t * (2 - t); }
    public static float easeInOut(float t) { return t < 0.5f ? 2*t*t : -1 + (4 - 2*t)*t; }
}
