package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.math.Matrix3;
import dev.jkit.ionview.math.Vector2;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

public class Circle implements Shape {
    public float cx, cy, radius;

    @Override
    public ShapeType getType() { return ShapeType.CIRCLE; }

    @Override
    public Bounds getBounds() {
        return new Bounds(cx - radius, cy - radius, cx + radius, cy + radius);
    }

    @Override
    public void transform(Matrix3 matrix) {
        Vector2 c = matrix.multiply(new Vector2(cx, cy));
        this.cx = c.x;
        this.cy = c.y;
        this.radius *= (matrix.getScaleX() + matrix.getScaleY()) / 2.0;
    }
}

