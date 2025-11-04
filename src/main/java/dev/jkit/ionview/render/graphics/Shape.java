package dev.jkit.ionview.render.graphics;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.math.Matrix3;

public interface Shape {
    ShapeType getType();
    Bounds getBounds();
    void transform(Matrix3 matrix);
}
