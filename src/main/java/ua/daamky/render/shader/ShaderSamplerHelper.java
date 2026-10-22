package ua.daamky.render.shader;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class ShaderSamplerHelper {
    private static final ShaderSamplerHelper INSTANCE = new ShaderSamplerHelper();
    private ShaderSamplerHelper() {}
    public static ShaderSamplerHelper handle() { return INSTANCE; }
    public static ShaderSamplerHelper process() { return INSTANCE; }
    public static ShaderSamplerHelper compute() { return INSTANCE; }
    public static ShaderSamplerHelper resolve() { return INSTANCE; }
    public static ShaderSamplerHelper get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
