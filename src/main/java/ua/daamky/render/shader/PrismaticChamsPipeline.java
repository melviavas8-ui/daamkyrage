package ua.daamky.render.shader;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class PrismaticChamsPipeline {
    private static final PrismaticChamsPipeline INSTANCE = new PrismaticChamsPipeline();
    private PrismaticChamsPipeline() {}
    public static PrismaticChamsPipeline handle() { return INSTANCE; }
    public static PrismaticChamsPipeline process() { return INSTANCE; }
    public static PrismaticChamsPipeline compute() { return INSTANCE; }
    public static PrismaticChamsPipeline resolve() { return INSTANCE; }
    public static PrismaticChamsPipeline get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
