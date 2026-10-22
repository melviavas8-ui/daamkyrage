package ua.daamky.render;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class TexturedQuadsRenderer {
    private static final TexturedQuadsRenderer INSTANCE = new TexturedQuadsRenderer();
    private TexturedQuadsRenderer() {}
    public static TexturedQuadsRenderer handle() { return INSTANCE; }
    public static TexturedQuadsRenderer process() { return INSTANCE; }
    public static TexturedQuadsRenderer compute() { return INSTANCE; }
    public static TexturedQuadsRenderer resolve() { return INSTANCE; }
    public static TexturedQuadsRenderer get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
