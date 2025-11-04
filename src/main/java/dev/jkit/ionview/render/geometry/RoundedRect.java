package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.math.Matrix3;
import dev.jkit.ionview.math.Vector2;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

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
    public ShapeType getType() { return ShapeType.ROUNDED_RECT; }

    @Override
    public Bounds getBounds() { return new Bounds(x, y, x + width, y + height); }

    @Override
    public void transform(Matrix3 matrix) {
        Vector2 topLeft = matrix.multiply(new Vector2(x, y));
        Vector2 bottomRight = matrix.multiply(new Vector2(x + width, y + height));
        this.x = topLeft.x;
        this.y = topLeft.y;
        this.width = bottomRight.x - topLeft.x;
        this.height = bottomRight.y - topLeft.y;

        this.radius = new BorderRadius(
                radius.topLeft() * matrix.getScaleX(),
                radius.topRight() * matrix.getScaleX(),
                radius.bottomRight() * matrix.getScaleX(),
                radius.bottomLeft() * matrix.getScaleX()
        );
    }
}
