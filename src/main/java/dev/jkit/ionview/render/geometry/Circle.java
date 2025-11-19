package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;
import org.joml.Matrix3x2f;
import org.joml.Vector2f;

public class Circle implements Shape {

    public float cx, cy, radius;

    @Override
    public ShapeType getType() {
        return ShapeType.CIRCLE;
    }

    @Override
    public Bounds getBounds() {
        return new Bounds(
                cx - radius,
                cy - radius,
                cx + radius,
                cy + radius
        );
    }

    @Override
    public void transform(Matrix3x2f matrix) {
        Vector2f c = matrix.transformPosition(new Vector2f(cx, cy));
        this.cx = c.x;
        this.cy = c.y;

        float sx = (float)Math.sqrt(matrix.m00() * matrix.m00() + matrix.m01() * matrix.m01());
        float sy = (float)Math.sqrt(matrix.m10() * matrix.m10() + matrix.m11() * matrix.m11());
        float avgScale = (sx + sy) * 0.5f;

        this.radius *= avgScale;
    }
}

