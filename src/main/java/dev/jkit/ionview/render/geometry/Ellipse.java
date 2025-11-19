package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;
import dev.jkit.ionview.math.Bounds;
import org.joml.Matrix3x2f;
import org.joml.Vector2f;

public class Ellipse implements Shape {

    public float x, y;
    public float radiusX, radiusY;

    public Ellipse(float x, float y, float radiusX, float radiusY) {
        this.x = x;
        this.y = y;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.ELLIPSE;
    }

    @Override
    public Bounds getBounds() {
        return new Bounds(
                x - radiusX,
                y - radiusY,
                x + radiusX,
                y + radiusY
        );
    }

    @Override
    public void transform(Matrix3x2f m) {
        Vector2f center = m.transformPosition(new Vector2f(x, y));
        this.x = center.x;
        this.y = center.y;

        float scaleX = (float)Math.sqrt(m.m00() * m.m00() + m.m01() * m.m01());
        float scaleY = (float)Math.sqrt(m.m10() * m.m10() + m.m11() * m.m11());

        radiusX *= scaleX;
        radiusY *= scaleY;
    }
}
