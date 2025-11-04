package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.math.Matrix3;
import dev.jkit.ionview.math.Vector2;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

public class Ellipse implements Shape {
    public float x, y, radiusX, radiusY;

    public Ellipse(float x, float y, float radiusX, float radiusY) {
        this.x = x;
        this.y = y;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public ShapeType getType() { return ShapeType.ELLIPSE; }

    @Override
    public Bounds getBounds() {
        return new Bounds(x - radiusX, y - radiusY, x + radiusX, y + radiusY);
    }

    @Override
    public void transform(Matrix3 matrix) {
        Vector2 center = matrix.multiply(new Vector2(x, y));
        this.x = center.x;
        this.y = center.y;
        this.radiusX *= matrix.getScaleX();
        this.radiusY *= matrix.getScaleY();
    }
}
