package dev.jkit.ionview.math;

public class Transform {
    private Vector3 position = new Vector3(0, 0, 0);
    private Quaternion rotation = Quaternion.identity();
    private Vector3 scale = new Vector3(1, 1, 1);

    public Transform() {}

    public Transform(Vector3 position, Quaternion rotation, Vector3 scale) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Vector3 getPosition() { return position; }
    public Quaternion getRotation() { return rotation; }
    public Vector3 getScale() { return scale; }

    public void setPosition(Vector3 pos) { this.position = pos; }
    public void setRotation(Quaternion rot) { this.rotation = rot; }
    public void setScale(Vector3 scale) { this.scale = scale; }

    public Matrix4 toMatrix() {
        Matrix4 translation = new Matrix4().translate(position.x, position.y, position.z);
        Matrix4 rotationMat = rotation.toMatrix4();
        Matrix4 scaleMat = new Matrix4().scale(scale.x, scale.y, scale.z);
        return translation.multiply(rotationMat).multiply(scaleMat);
    }

    public Transform combine(Transform other) {
        Transform t = new Transform();
        t.position = position.add(rotation.rotate(other.position));
        t.rotation = rotation.multiply(other.rotation).normalized();
        t.scale = new Vector3(scale.x * other.scale.x, scale.y * other.scale.y, scale.z * other.scale.z);
        return t;
    }

    @Override
    public String toString() {
        return String.format("Transform(pos=%s, rot=%s, scale=%s)", position, rotation, scale);
    }
}
