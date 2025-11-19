package dev.jkit.ionview.render.geometry;

import org.joml.Vector2f;

import java.util.List;

public class GeometryUtils {

    public static float area(List<Vector2f> vertices) {
        float area = 0;
        int j = vertices.size() - 1;
        for (int i = 0; i < vertices.size(); i++) {
            Vector2f vi = vertices.get(i);
            Vector2f vj = vertices.get(j);
            area += (vj.x + vi.x) * (vj.y - vi.y);
            j = i;
        }
        return Math.abs(area / 2.0f);
    }

    public static boolean pointInPolygon(Vector2f point, List<Vector2f> vertices) {
        boolean inside = false;
        int j = vertices.size() - 1;
        for (int i = 0; i < vertices.size(); i++) {
            Vector2f vi = vertices.get(i);
            Vector2f vj = vertices.get(j);
            if ((vi.y > point.y) != (vj.y > point.y) &&
                    point.x < (vj.x - vi.x) * (point.y - vi.y) / (vj.y - vi.y) + vi.x) {
                inside = !inside;
            }
            j = i;
        }
        return inside;
    }
}
