package dev.jkit.ionview.render.render_tree;

public interface RendererBackend {
    void beginFrame(int width, int height);
    void draw(PaintCommand command);
    void endFrame();
}
