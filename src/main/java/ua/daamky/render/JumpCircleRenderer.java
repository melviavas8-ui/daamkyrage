package ua.daamky.render;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class JumpCircleRenderer {
    private static final JumpCircleRenderer INSTANCE = new JumpCircleRenderer();
    private JumpCircleRenderer() {}
    public static JumpCircleRenderer handle() { return INSTANCE; }
    public static JumpCircleRenderer process() { return INSTANCE; }
    public static JumpCircleRenderer compute() { return INSTANCE; }
    public static JumpCircleRenderer resolve() { return INSTANCE; }
    public static JumpCircleRenderer get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
