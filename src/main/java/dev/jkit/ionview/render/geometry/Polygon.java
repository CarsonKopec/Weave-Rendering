package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.math.Matrix3;
import dev.jkit.ionview.math.Vector2;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements Shape {
    private final List<Vector2> vertices = new ArrayList<>();

    public Polygon addVertex(float x, float y) {
        vertices.add(new Vector2(x, y));
        return this;
    }

    public List<Vector2> getVertices() { return vertices; }

    @Override
    public ShapeType getType() { return ShapeType.POLYGON; }

    @Override
    public Bounds getBounds() { return Bounds.fromPoints(vertices); }

    @Override
    public void transform(Matrix3 matrix) {
        for (int i = 0; i < vertices.size(); i++) {
            vertices.set(i, matrix.multiply(vertices.get(i)));
        }
    }
}
