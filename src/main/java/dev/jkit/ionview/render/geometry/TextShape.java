package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.math.Matrix3;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

public class TextShape implements Shape {
    public String text;
    public float x, y;
    public String fontFamily;
    public float fontSize;

    @Override
    public ShapeType getType() { return ShapeType.TEXT; }

    @Override
    public Bounds getBounds() {
        return new Bounds(x, y - fontSize, x + text.length() * fontSize * 0.5f, y);
    }

    @Override
    public void transform(Matrix3 matrix) {
    }
}
