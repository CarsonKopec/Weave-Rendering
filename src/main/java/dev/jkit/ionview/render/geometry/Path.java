package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

import org.joml.Matrix3x2f;
import org.joml.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class Path implements Shape {
    private final List<Vector2f> points = new ArrayList<>();
    private boolean closed = false;

    public void moveTo(float x, float y) {
        points.add(new Vector2f(x, y));
    }

    public void lineTo(float x, float y) {
        points.add(new Vector2f(x, y));
    }

    public void close() { closed = true; }

    @Override
    public ShapeType getType() { return ShapeType.PATH; }

    @Override
    public Bounds getBounds() {
        return Bounds.fromPoints(points);
    }

    @Override
    public void transform(Matrix3x2f matrix) {
        for (Vector2f p : points) {
            matrix.transformPosition(p);
        }
    }
}
