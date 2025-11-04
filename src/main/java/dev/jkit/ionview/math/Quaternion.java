package dev.jkit.ionview.math;

public class Quaternion {
    public float x, y, z, w;

    public Quaternion() { this(0,0,0,1); }
    public Quaternion(float x, float y, float z, float w) {
        this.x=x; this.y=y; this.z=z; this.w=w;
    }

    public Quaternion set(float x, float y, float z, float w) {
        this.x=x; this.y=y; this.z=z; this.w=w; return this;
    }

    public Quaternion nor() {
        float len = (float)Math.sqrt(x*x+y*y+z*z+w*w);
        if (len != 0) set(x/len, y/len, z/len, w/len);
        return this;
    }

    public Quaternion mul(Quaternion q) {
        return set(
                w*q.x + x*q.w + y*q.z - z*q.y,
                w*q.y - x*q.z + y*q.w + z*q.x,
                w*q.z + x*q.y - y*q.x + z*q.w,
                w*q.w - x*q.x - y*q.y - z*q.z
        );
    }

    public static Quaternion fromAxisAngle(Vector3 axis, float degrees) {
        float half = (float)Math.toRadians(degrees/2);
        float s = (float)Math.sin(half);
        return new Quaternion(axis.x*s, axis.y*s, axis.z*s, (float)Math.cos(half)).nor();
    }
}
