package dev.jkit.ionview.math;

public class Matrix3 {
    public float[] val = new float[9];

    public Matrix3() { idt(); }

    public Matrix3 idt() {
        val[0] = 1; val[3] = 0; val[6] = 0;
        val[1] = 0; val[4] = 1; val[7] = 0;
        val[2] = 0; val[5] = 0; val[8] = 1;
        return this;
    }

    public Matrix3 set(Matrix3 m) {
        System.arraycopy(m.val, 0, val, 0, 9);
        return this;
    }

    public Matrix3 mul(Matrix3 m) {
        float[] a = val, b = m.val;
        float[] r = new float[9];
        for (int row=0; row<3; row++)
            for (int col=0; col<3; col++)
                r[col + row*3] =
                        a[row*3] * b[col] +
                                a[row*3+1] * b[col+3] +
                                a[row*3+2] * b[col+6];
        val = r;
        return this;
    }

    public Vector2 transform(Vector2 v) {
        float x = v.x, y = v.y;
        v.x = val[0]*x + val[3]*y + val[6];
        v.y = val[1]*x + val[4]*y + val[7];
        return v;
    }

    public Matrix3 translate(float x, float y) {
        Matrix3 t = new Matrix3().idt();
        t.val[6] = x; t.val[7] = y;
        return mul(t);
    }

    public Matrix3 scale(float sx, float sy) {
        Matrix3 s = new Matrix3().idt();
        s.val[0] = sx; s.val[4] = sy;
        return mul(s);
    }

    public Matrix3 rotate(float degrees) {
        Matrix3 r = new Matrix3().idt();
        float rad = (float)Math.toRadians(degrees);
        float c = (float)Math.cos(rad);
        float s = (float)Math.sin(rad);
        r.val[0] = c; r.val[3] = -s;
        r.val[1] = s; r.val[4] = c;
        return mul(r);
    }

    @Override public String toString() {
        return String.format(
                "[%.2f, %.2f, %.2f]\n[%.2f, %.2f, %.2f]\n[%.2f, %.2f, %.2f]",
                val[0], val[3], val[6],
                val[1], val[4], val[7],
                val[2], val[5], val[8]);
    }
}
