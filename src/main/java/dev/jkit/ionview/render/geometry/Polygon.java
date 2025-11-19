package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

import org.joml.Matrix3x2f;
import org.joml.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements Shape {
    private final List<Vector2f> vertices = new ArrayList<>();

    public Polygon addVertex(float x, float y) {
        vertices.add(new Vector2f(x, y));
        return this;
    }

    public List<Vector2f> getVertices() {
        return vertices;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.POLYGON;
    }

    @Override
    public Bounds getBounds() {
        return Bounds.fromPoints(vertices);
    }

    @Override
    public void transform(Matrix3x2f matrix) {
        for (Vector2f v : vertices) {
            matrix.transformPosition(v);
        }
    }
}
