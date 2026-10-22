package org.daamky.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BackgroundRenderer.class)
public class FogRendererMixin {
   // 1.21.4 fog API differs; keep soft inject. Full fog control re-enabled later.
   @Inject(method = "applyFog", at = @At("HEAD"), require = 0)
   private static void daamky$fogHook(CallbackInfoReturnable<?> cir) {}
}
