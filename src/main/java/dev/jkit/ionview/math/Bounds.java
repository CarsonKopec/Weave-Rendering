package dev.jkit.ionview.math;

public class Bounds {
    public final Vector2 min = new Vector2();
    public final Vector2 max = new Vector2();

    public Bounds() {}
    public Bounds(Vector2 min, Vector2 max) { this.min.set(min); this.max.set(max); }

    public Vector2 getCenter() {
        return new Vector2((min.x+max.x)/2f, (min.y+max.y)/2f);
    }

    public Vector2 getSize() {
        return new Vector2(max.x - min.x, max.y - min.y);
    }

    public boolean contains(Vector2 p) {
        return p.x >= min.x && p.x <= max.x && p.y >= min.y && p.y <= max.y;
    }

    public boolean intersects(Bounds other) {
        return !(other.max.x < min.x || other.min.x > max.x ||
                other.max.y < min.y || other.min.y > max.y);
    }

    public Bounds expand(float amount) {
        min.x -= amount; min.y -= amount;
        max.x += amount; max.y += amount;
        return this;
    }

    @Override public String toString() {
        return "Bounds[min=" + min + ", max=" + max + "]";
    }
}
