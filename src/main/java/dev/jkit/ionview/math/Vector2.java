package dev.jkit.ionview.math;

public class Vector2 {
    public float x, y;

    public Vector2() { this(0, 0); }
    public Vector2(float x, float y) { this.x = x; this.y = y; }
    public Vector2(Vector2 v) { this(v.x, v.y); }

    public Vector2 set(float x, float y) { this.x = x; this.y = y; return this; }
    public Vector2 set(Vector2 v) { return set(v.x, v.y); }

    public Vector2 add(Vector2 v) { x += v.x; y += v.y; return this; }
    public Vector2 sub(Vector2 v) { x -= v.x; y -= v.y; return this; }
    public Vector2 scl(float s) { x *= s; y *= s; return this; }
    public Vector2 scl(Vector2 v) { x *= v.x; y *= v.y; return this; }

    public float dot(Vector2 v) { return x * v.x + y * v.y; }
    public float len() { return (float)Math.sqrt(x*x + y*y); }
    public float len2() { return x*x + y*y; }
    public Vector2 nor() { float l = len(); if (l != 0) scl(1f / l); return this; }

    public Vector2 rotate(float degrees) {
        float rad = (float)Math.toRadians(degrees);
        float cos = (float)Math.cos(rad);
        float sin = (float)Math.sin(rad);
        float newX = x * cos - y * sin;
        float newY = x * sin + y * cos;
        x = newX; y = newY;
        return this;
    }

    public float dst(Vector2 v) { return (float)Math.sqrt(dst2(v)); }
    public float dst2(Vector2 v) { float dx = v.x - x, dy = v.y - y; return dx*dx + dy*dy; }

    public Vector2 clamp(float min, float max) {
        float l2 = len2();
        if (l2 == 0f) return this;
        if (l2 > max * max) scl(max / (float)Math.sqrt(l2));
        else if (l2 < min * min) scl(min / (float)Math.sqrt(l2));
        return this;
    }

    public Vector2 cpy() { return new Vector2(this); }

    @Override public String toString() { return "(" + x + ", " + y + ")"; }
}
