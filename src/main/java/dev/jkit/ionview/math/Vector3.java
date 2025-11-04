package dev.jkit.ionview.math;

public class Vector3 {
    public float x, y, z;

    public Vector3() { this(0, 0, 0); }
    public Vector3(float x, float y, float z) { this.x = x; this.y = y; this.z = z; }
    public Vector3(Vector3 v) { this(v.x, v.y, v.z); }

    public Vector3 set(float x, float y, float z) { this.x = x; this.y = y; this.z = z; return this; }
    public Vector3 set(Vector3 v) { return set(v.x, v.y, v.z); }

    public Vector3 add(Vector3 v) { x += v.x; y += v.y; z += v.z; return this; }
    public Vector3 sub(Vector3 v) { x -= v.x; y -= v.y; z -= v.z; return this; }
    public Vector3 scl(float s) { x *= s; y *= s; z *= s; return this; }
    public Vector3 scl(Vector3 v) { x *= v.x; y *= v.y; z *= v.z; return this; }

    public float dot(Vector3 v) { return x*v.x + y*v.y + z*v.z; }
    public Vector3 cross(Vector3 v) {
        return set(
                y*v.z - z*v.y,
                z*v.x - x*v.z,
                x*v.y - y*v.x
        );
    }

    public float len() { return (float)Math.sqrt(x*x + y*y + z*z); }
    public float len2() { return x*x + y*y + z*z; }
    public Vector3 nor() { float l = len(); if (l != 0) scl(1f / l); return this; }

    public float dst(Vector3 v) { return (float)Math.sqrt(dst2(v)); }
    public float dst2(Vector3 v) { float dx=v.x-x, dy=v.y-y, dz=v.z-z; return dx*dx+dy*dy+dz*dz; }

    public Vector3 cpy() { return new Vector3(this); }
    @Override public String toString() { return "(" + x + ", " + y + ", " + z + ")"; }
}
