package org.daamky.mixin;

import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import ua.daamky.DaamkyClient;
import ua.daamky.modules.player.FreeCamera;
import ua.daamky.modules.visuals.FullBright;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {
   @Redirect(method = "update", at = @At(value = "INVOKE", target = "Ljava/lang/Double;floatValue()F", ordinal = 1))
   private float getGammaValue(Double var1) {
      if (!DaamkyClient.prepare()) {
         return var1.floatValue();
      }

      if (FreeCamera.render()) {
         return 200.0F;
      }

      if (DaamkyClient.instance != null && DaamkyClient.instance.data != null) {
         FullBright var2 = DaamkyClient.instance.data.handle(FullBright.class);
         if (var2 != null && var2.enabled) {
            if (var2.refresh()) {
               return 200.0F;
            }

            if (var2.render()) {
               return var2.load();
            }

            if (var2.tick()) {
               return var2.animate();
            }
         }
      }

      return var1.floatValue();
   }

   @Redirect(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/dimension/DimensionType;ambientLight()F"))
   private float getAmbientFloor(DimensionType var1) {
      float var2 = var1.ambientLight();
      if (DaamkyClient.instance != null && DaamkyClient.instance.data != null) {
         FullBright var3 = DaamkyClient.instance.data.handle(FullBright.class);
         if (var3 != null && var3.enabled && var3.tick()) {
            return Math.max(var2, var3.encodePoint());
         }
      }

      return var2;
   }
}
