package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;
import org.joml.Matrix3x2f;
import org.joml.Vector2f;

public class ImageShape implements Shape {

    public float x, y;
    public float width, height;
    public Texture texture;

    @Override
    public ShapeType getType() {
        return ShapeType.IMAGE;
    }

    @Override
    public Bounds getBounds() {
        return new Bounds(x, y, x + width, y + height);
    }

    @Override
    public void transform(Matrix3x2f m) {
        Vector2f p1 = new Vector2f(x, y).mulPosition(m);
        Vector2f p2 = new Vector2f(x + width, y).mulPosition(m);
        Vector2f p3 = new Vector2f(x + width, y + height).mulPosition(m);
        Vector2f p4 = new Vector2f(x, y + height).mulPosition(m);

        Bounds b = Bounds.empty();
        b.include(p1.x, p1.y);
        b.include(p2.x, p2.y);
        b.include(p3.x, p3.y);
        b.include(p4.x, p4.y);

        // Store new values
        this.x = b.minX;
        this.y = b.minY;
        this.width = b.maxX - b.minX;
        this.height = b.maxY - b.minY;
    }
}
