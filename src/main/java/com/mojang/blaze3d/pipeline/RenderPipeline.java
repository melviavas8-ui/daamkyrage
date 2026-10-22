package com.mojang.blaze3d.pipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import net.minecraft.util.Identifier;
public class RenderPipeline {
  public static class Snippet {}
  public static class Builder {
    public Builder withLocation(Identifier id) { return this; }
    public Builder withVertexShader(Identifier id) { return this; }
    public Builder withFragmentShader(Identifier id) { return this; }
    public Builder withVertexFormat(Object vf, Object mode) { return this; }
    public Builder withCull(boolean v) { return this; }
    public Builder withDepthTestFunction(Object f) { return this; }
    public Builder withDepthWrite(boolean v) { return this; }
    public Builder withBlend(BlendFunction b) { return this; }
    public Builder withColorWrite(boolean a, boolean b) { return this; }
    public Builder withUniform(String n, Object t) { return this; }
    public Builder withSampler(String n) { return this; }
    public Builder withShaderDefine(String n) { return this; }
    public RenderPipeline build() { return new RenderPipeline(); }
  }
  public static Builder builder(Snippet... s) { return new Builder(); }
}
