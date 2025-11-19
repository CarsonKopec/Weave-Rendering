package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Bounds;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.graphics.ShapeType;

import org.joml.Matrix3x2f;
import org.joml.Vector2f;

public class TextShape implements Shape {
    public String text;
    public float x, y;
    public String fontFamily;
    public float fontSize;

    public TextShape(String text, float x, float y, String fontFamily, float fontSize) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.TEXT;
    }

    @Override
    public Bounds getBounds() {
        return new Bounds(
                x,
                y - fontSize,
                x + text.length() * fontSize * 0.5f,
                y
        );
    }

    @Override
    public void transform(Matrix3x2f matrix) {
        Vector2f pos = new Vector2f(x, y);
        matrix.transformPosition(pos);
        x = pos.x;
        y = pos.y;
    }
}
