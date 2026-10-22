package ua.daamky.util.inventory;

import net.minecraft.client.render.RenderLayer;

/** 1.21.4 port stub (RenderPipeline/Gpu* not in 1.21.4). */
public final class ItemStackOverlayRenderer {
    private static final ItemStackOverlayRenderer INSTANCE = new ItemStackOverlayRenderer();
    private ItemStackOverlayRenderer() {}
    public static ItemStackOverlayRenderer handle() { return INSTANCE; }
    public static ItemStackOverlayRenderer process() { return INSTANCE; }
    public static ItemStackOverlayRenderer compute() { return INSTANCE; }
    public static ItemStackOverlayRenderer resolve() { return INSTANCE; }
    public static ItemStackOverlayRenderer get() { return INSTANCE; }
    public static void update() {}
    public static void refresh() {}
    public static RenderLayer layer() { return null; }
    public void close() {}
    public void draw() {}
    public void render() {}
}
