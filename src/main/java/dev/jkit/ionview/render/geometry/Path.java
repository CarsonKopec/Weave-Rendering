package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.math.Matrix3;
import dev.jkit.ionview.math.Vector2;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

import java.util.ArrayList;
import java.util.List;

public class Path implements Shape {
    private final List<Vector2> points = new ArrayList<>();
    private boolean closed = false;

    public void moveTo(float x, float y) { points.add(new Vector2(x, y)); }
    public void lineTo(float x, float y) { points.add(new Vector2(x, y)); }
    public void close() { closed = true; }

    @Override
    public ShapeType getType() { return ShapeType.PATH; }

    @Override
    public Bounds getBounds() { return Bounds.fromPoints(points); }

    @Override
    public void transform(Matrix3 matrix) {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, matrix.multiply(points.get(i)));
        }
    }
}

