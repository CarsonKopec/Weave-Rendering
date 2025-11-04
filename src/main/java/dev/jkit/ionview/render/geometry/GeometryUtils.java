package dev.jkit.ionview.render.geometry;

import dev.jkit.ionview.math.Vector2;

import java.util.List;

public class GeometryUtils {

    public static float area(List<Vector2> vertices) {
        float area = 0;
        int j = vertices.size() - 1;
        for (int i = 0; i < vertices.size(); i++) {
            Vector2 vi = vertices.get(i);
            Vector2 vj = vertices.get(j);
            area += (vj.x + vi.x) * (vj.y - vi.y);
            j = i;
        }
        return Math.abs(area / 2.0f);
    }

    public static boolean pointInPolygon(Vector2 point, List<Vector2> vertices) {
        boolean inside = false;
        int j = vertices.size() - 1;
        for (int i = 0; i < vertices.size(); i++) {
            Vector2 vi = vertices.get(i);
            Vector2 vj = vertices.get(j);
            if (((vi.y > point.y) != (vj.y > point.y)) &&
                    (point.x < (vj.x - vi.x) * (point.y - vi.y) / (vj.y - vi.y) + vi.x))
                inside = !inside;
            j = i;
        }
        return inside;
    }
}
