package net.minecraft.client.gl;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
public class RenderPipelines {
  public static final Snippet TRANSFORMS_AND_PROJECTION_SNIPPET = new Snippet();
  public static final Snippet GLOBALS_SNIPPET = new Snippet();
  public static final Snippet FOG_SNIPPET = new Snippet();
  public static final Snippet MATRICES_FOG_SNIPPET = new Snippet();
  public static final Snippet TEXTURE_SNIPPET = new Snippet();
  public static final Snippet POSITION_COLOR_SNIPPET = new Snippet();
  public static RenderPipeline register(RenderPipeline p) { return p; }
  public static RenderPipeline.Builder builder(Snippet... s) { return RenderPipeline.builder(s); }
}
