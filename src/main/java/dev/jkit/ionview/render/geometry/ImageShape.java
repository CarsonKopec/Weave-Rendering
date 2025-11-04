package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.math.Matrix3;
import dev.jkit.ionview.math.Vector2;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

public class ImageShape implements Shape {
    public float x, y, width, height;
    public Texture texture;

    @Override
    public ShapeType getType() { return ShapeType.IMAGE; }

    @Override
    public Bounds getBounds() {
        return new Bounds(x, y, x + width, y + height);
    }

    @Override
    public void transform(Matrix3 matrix) {
        Vector2 topLeft = matrix.multiply(new Vector2(x, y));
        Vector2 bottomRight = matrix.multiply(new Vector2(x + width, y + height));
        x = topLeft.x;
        y = topLeft.y;
        width = bottomRight.x - topLeft.x;
        height = bottomRight.y - topLeft.y;
    }
}
