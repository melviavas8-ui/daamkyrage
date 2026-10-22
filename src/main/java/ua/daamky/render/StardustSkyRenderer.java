package ua.daamky.render;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class StardustSkyRenderer {
    private static final StardustSkyRenderer INSTANCE = new StardustSkyRenderer();
    private StardustSkyRenderer() {}
    public static StardustSkyRenderer handle() { return INSTANCE; }
    public static StardustSkyRenderer process() { return INSTANCE; }
    public static StardustSkyRenderer compute() { return INSTANCE; }
    public static StardustSkyRenderer resolve() { return INSTANCE; }
    public static StardustSkyRenderer get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
