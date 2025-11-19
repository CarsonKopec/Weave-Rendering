package dev.jkit.ionview.render.geometry;

public class BorderRadius {
    private final float topLeft;
    private final float topRight;
    private final float bottomRight;
    private final float bottomLeft;

    public static final BorderRadius ZERO = new BorderRadius(0);

    public BorderRadius(float radius) {
        this(radius, radius, radius, radius);
    }

    public BorderRadius(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
        this.bottomLeft = bottomLeft;
    }


    public float topLeft() { return topLeft; }
    public float topRight() { return topRight; }
    public float bottomRight() { return bottomRight; }
    public float bottomLeft() { return bottomLeft; }

    public BorderRadius scaled(float factor) {
        return new BorderRadius(
                topLeft * factor,
                topRight * factor,
                bottomRight * factor,
                bottomLeft * factor
        );
    }

    @Override
    public String toString() {
        return String.format("BorderRadius[topLeft=%.2f, topRight=%.2f, bottomRight=%.2f, bottomLeft=%.2f]",
                topLeft, topRight, bottomRight, bottomLeft);
    }
}
