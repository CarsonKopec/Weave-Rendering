package dev.jkit.ionview.render.style;

public class Color {
    public double r, g, b, a;

    public Color(double r, double g, double b, double a) {
        this.r = clamp(r); this.g = clamp(g); this.b = clamp(b); this.a = clamp(a);
    }

    public static Color fromRGB(int r, int g, int b) {
        return new Color(r / 255.0, g / 255.0, b / 255.0, 1.0);
    }

    public static Color fromRGBA(int r, int g, int b, int a) {
        return new Color(r / 255.0, g / 255.0, b / 255.0, a / 255.0);
    }

    public static Color fromHSL(double h, double s, double l) {
        h = (h % 360) / 360.0;
        double c = (1 - Math.abs(2 * l - 1)) * s;
        double x = c * (1 - Math.abs((h * 6) % 2 - 1));
        double m = l - c / 2;
        double r, g, b;

        if (h < 1.0/6) { r = c; g = x; b = 0; }
        else if (h < 2.0/6) { r = x; g = c; b = 0; }
        else if (h < 3.0/6) { r = 0; g = c; b = x; }
        else if (h < 4.0/6) { r = 0; g = x; b = c; }
        else if (h < 5.0/6) { r = x; g = 0; b = c; }
        else { r = c; g = 0; b = x; }

        return new Color(r + m, g + m, b + m, 1.0);
    }

    public int toARGB() {
        int R = (int)(r * 255);
        int G = (int)(g * 255);
        int B = (int)(b * 255);
        int A = (int)(a * 255);
        return (A << 24) | (R << 16) | (G << 8) | B;
    }

    private double clamp(double v) {
        return Math.max(0.0, Math.min(1.0, v));
    }

    @Override
    public String toString() {
        return String.format("Color(r=%.3f, g=%.3f, b=%.3f, a=%.3f)", r, g, b, a);
    }

    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    public static final Color WHITE = new Color(1, 1, 1, 1);
    public static final Color BLACK = new Color(0, 0, 0, 1);
    public static final Color RED = new Color(1, 0, 0, 1);
    public static final Color GREEN = new Color(0, 1, 0, 1);
    public static final Color BLUE = new Color(0, 0, 1, 1);
}
