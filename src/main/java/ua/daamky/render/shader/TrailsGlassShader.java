package ua.daamky.render.shader;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class TrailsGlassShader {
    private static final TrailsGlassShader INSTANCE = new TrailsGlassShader();
    private TrailsGlassShader() {}
    public static TrailsGlassShader handle() { return INSTANCE; }
    public static TrailsGlassShader process() { return INSTANCE; }
    public static TrailsGlassShader compute() { return INSTANCE; }
    public static TrailsGlassShader resolve() { return INSTANCE; }
    public static TrailsGlassShader get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
