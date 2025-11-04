package dev.jkit.ionview.render.render_tree;

import dev.jkit.ionview.math.Matrix3;
import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.style.PaintStyle;

public record PaintCommand(Shape shape, PaintStyle style, Matrix3 transform, float opacity) {}

