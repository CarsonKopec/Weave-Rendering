package dev.jkit.ionview.render.graphics;


import dev.jkit.ionview.math.Bounds;
import org.joml.Matrix3x2f;

public interface Shape {
    ShapeType getType();
    Bounds getBounds();
    void transform(Matrix3x2f matrix);
}
