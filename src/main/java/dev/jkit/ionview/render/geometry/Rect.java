package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

import org.joml.Matrix3x2f;
import org.joml.Vector2f;

public class Rect implements Shape {
    public float x, y, width, height;
    public BorderRadius radius = BorderRadius.ZERO;

    @Override
    public ShapeType getType() {
        return ShapeType.RECT;
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
    }
}
