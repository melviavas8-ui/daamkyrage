package ua.daamky.render;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class BlockEspRenderPipeline {
    private static final BlockEspRenderPipeline INSTANCE = new BlockEspRenderPipeline();
    private BlockEspRenderPipeline() {}
    public static BlockEspRenderPipeline handle() { return INSTANCE; }
    public static BlockEspRenderPipeline process() { return INSTANCE; }
    public static BlockEspRenderPipeline compute() { return INSTANCE; }
    public static BlockEspRenderPipeline resolve() { return INSTANCE; }
    public static BlockEspRenderPipeline get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
