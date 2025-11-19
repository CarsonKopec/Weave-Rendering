package dev.jkit.ionview.math;

import org.joml.Matrix3x2f;
import org.joml.Vector2f;

public class Bounds {
    public float minX, minY;
    public float maxX, maxY;

    // -----------------------------------------------------
    // Constructors
    // -----------------------------------------------------
    public Bounds(float minX, float minY, float maxX, float maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public Bounds(Vector2f a, Vector2f b) {
        this.minX = Math.min(a.x, b.x);
        this.minY = Math.min(a.y, b.y);
        this.maxX = Math.max(a.x, b.x);
        this.maxY = Math.max(a.y, b.y);
    }

    public static Bounds empty() {
        return new Bounds(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY,
                Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    }

    // -----------------------------------------------------
    // Factory from point list
    // -----------------------------------------------------
    public static Bounds fromPoints(Iterable<Vector2f> points) {
        Bounds b = empty();
        for (Vector2f p : points) {
            b.include(p.x, p.y);
        }
        return b;
    }

    // -----------------------------------------------------
    // Core operations
    // -----------------------------------------------------
    public float width() {
        return maxX - minX;
    }

    public float height() {
        return maxY - minY;
    }

    public Vector2f center() {
        return new Vector2f((minX + maxX) * 0.5f, (minY + maxY) * 0.5f);
    }

    // Expand bounds to include a point
    public void include(float x, float y) {
        if (x < minX) minX = x;
        if (y < minY) minY = y;
        if (x > maxX) maxX = x;
        if (y > maxY) maxY = y;
    }

    public void include(Vector2f p) {
        include(p.x, p.y);
    }

    // Expand bounds by merging another Bounds
    public void include(Bounds b) {
        include(b.minX, b.minY);
        include(b.maxX, b.maxY);
    }

    // Check if point is inside
    public boolean contains(float x, float y) {
        return x >= minX && x <= maxX &&
                y >= minY && y <= maxY;
    }

    public boolean contains(Vector2f p) {
        return contains(p.x, p.y);
    }

    // Check if bounds intersects another
    public boolean intersects(Bounds b) {
        return !(b.minX > maxX || b.maxX < minX ||
                b.minY > maxY || b.maxY < minY);
    }

    // Inflate bounds outward (e.g., shadow padding)
    public void inflate(float amount) {
        minX -= amount;
        minY -= amount;
        maxX += amount;
        maxY += amount;
    }

    // -----------------------------------------------------
    // Transform bounds using matrix
    // (Corner-based; works for rotation & scale)
    // -----------------------------------------------------
    public Bounds transformed(Matrix3x2f m) {
        Vector2f c1 = m.transformPosition(new Vector2f(minX, minY));
        Vector2f c2 = m.transformPosition(new Vector2f(maxX, minY));
        Vector2f c3 = m.transformPosition(new Vector2f(maxX, maxY));
        Vector2f c4 = m.transformPosition(new Vector2f(minX, maxY));

        Bounds out = Bounds.empty();
        out.include(c1);
        out.include(c2);
        out.include(c3);
        out.include(c4);

        return out;
    }

    // -----------------------------------------------------
    // Utility
    // -----------------------------------------------------
    public Vector2f topLeft() { return new Vector2f(minX, minY); }
    public Vector2f bottomRight() { return new Vector2f(maxX, maxY); }

    @Override
    public String toString() {
        return "Bounds[" + minX + ", " + minY + " -> " + maxX + ", " + maxY + "]";
    }
}
