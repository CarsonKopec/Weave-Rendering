package dev.jkit.ionview.render.style;

public class PaintStyle {
    public Fill fill;
    public Stroke stroke;
    public Shadow shadow;
    public Filter filter;

    public PaintStyle withFill(Fill fill) {
        this.fill = fill;
        return this;
    }

    public PaintStyle withStroke(Stroke stroke) {
        this.stroke = stroke;
        return this;
    }
}

