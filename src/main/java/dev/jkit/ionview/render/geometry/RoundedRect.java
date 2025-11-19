package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

import org.joml.Matrix3x2f;
import org.joml.Vector2f;

public class RoundedRect implements Shape {
    public float x, y, width, height;
    public BorderRadius radius;

    public RoundedRect(float x, float y, float width, float height, BorderRadius radius) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.ROUNDED_RECT;
    }

    @Override
    public Bounds getBounds() {
        return new Bounds(x, y, x + width, y + height);
    }

    @Override
    public void transform(Matrix3x2f matrix) {
        Vector2f topLeft = new Vector2f(x, y);
        Vector2f bottomRight = new Vector2f(x + width, y + height);

        matrix.transformPosition(topLeft);
        matrix.transformPosition(bottomRight);

        this.x = topLeft.x;
        this.y = topLeft.y;
        this.width = bottomRight.x - topLeft.x;
        this.height = bottomRight.y - topLeft.y;

        float scale = (matrix.m00() + matrix.m11()) * 0.5f;

        this.radius = new BorderRadius(
                radius.topLeft() * scale,
                radius.topRight() * scale,
                radius.bottomRight() * scale,
                radius.bottomLeft() * scale
        );
    }
}
