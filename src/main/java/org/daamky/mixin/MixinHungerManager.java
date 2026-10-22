package org.daamky.mixin;

import net.minecraft.entity.player.HungerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ua.daamky.DaamkyClient;
import ua.daamky.modules.movement.Sprint;

@Mixin(HungerManager.class)
public class MixinHungerManager {
   @Inject(method = "getFoodLevel", at = @At("HEAD"), cancellable = true)
   private void onGetFoodLevel(CallbackInfoReturnable<Integer> var1) {
      if (DaamkyClient.prepare()) {
         if (DaamkyClient.instance != null && DaamkyClient.instance.data != null) {
            Sprint var2 = DaamkyClient.instance.data.handle(Sprint.class);
            if (var2 != null && var2.enabled && var2.previous.compute()) {
               var1.setReturnValue(8);
            }
         }
      }
   }
}
