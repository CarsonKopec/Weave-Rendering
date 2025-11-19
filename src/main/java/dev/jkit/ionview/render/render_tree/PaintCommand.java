package dev.jkit.ionview.render.render_tree;

import dev.jkit.ionview.render.graphics.Shape;
import dev.jkit.ionview.render.style.PaintStyle;

import org.joml.Matrix3f;

public record PaintCommand(Shape shape, PaintStyle style, Matrix3f transform, float opacity) {}

