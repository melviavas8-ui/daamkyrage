package ua.daamky.render.shader;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class StardustShader {
    private static final StardustShader INSTANCE = new StardustShader();
    private StardustShader() {}
    public static StardustShader handle() { return INSTANCE; }
    public static StardustShader process() { return INSTANCE; }
    public static StardustShader compute() { return INSTANCE; }
    public static StardustShader resolve() { return INSTANCE; }
    public static StardustShader get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
