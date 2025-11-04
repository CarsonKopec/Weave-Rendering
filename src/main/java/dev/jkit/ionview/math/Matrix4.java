package dev.jkit.ionview.math;

public class Matrix4 {
    public float[] val = new float[16];

    public Matrix4() { idt(); }

    public Matrix4 idt() {
        for (int i=0;i<16;i++) val[i]=0;
        val[0]=val[5]=val[10]=val[15]=1;
        return this;
    }

    public Matrix4 translate(float x, float y, float z) {
        val[12]+=x; val[13]+=y; val[14]+=z;
        return this;
    }

    public Matrix4 scale(float sx, float sy, float sz) {
        val[0]*=sx; val[5]*=sy; val[10]*=sz;
        return this;
    }

    public Matrix4 mul(Matrix4 m) {
        float[] a = val, b = m.val;
        float[] r = new float[16];
        for (int row=0; row<4; row++)
            for (int col=0; col<4; col++)
                r[col + row*4] =
                        a[row*4]*b[col] +
                                a[row*4+1]*b[col+4] +
                                a[row*4+2]*b[col+8] +
                                a[row*4+3]*b[col+12];
        val = r;
        return this;
    }

    public Vector3 transform(Vector3 v) {
        float x=v.x, y=v.y, z=v.z;
        v.x = val[0]*x + val[4]*y + val[8]*z + val[12];
        v.y = val[1]*x + val[5]*y + val[9]*z + val[13];
        v.z = val[2]*x + val[6]*y + val[10]*z + val[14];
        return v;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<4;i++)
            sb.append(String.format("[%.2f, %.2f, %.2f, %.2f]\n",
                    val[i*4], val[i*4+1], val[i*4+2], val[i*4+3]));
        return sb.toString();
    }
}