package ua.daamky.render;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class BlockEspRenderer {
    private static final BlockEspRenderer INSTANCE = new BlockEspRenderer();
    private BlockEspRenderer() {}
    public static BlockEspRenderer handle() { return INSTANCE; }
    public static BlockEspRenderer process() { return INSTANCE; }
    public static BlockEspRenderer compute() { return INSTANCE; }
    public static BlockEspRenderer resolve() { return INSTANCE; }
    public static BlockEspRenderer get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
