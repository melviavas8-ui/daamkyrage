package org.daamky.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ua.daamky.DaamkyClient;
import ua.daamky.modules.misc.SeeInvisibles;

@Mixin(Entity.class)
public abstract class MixinEntity {
   @Inject(method = "isInvisibleTo", at = @At("HEAD"), cancellable = true)
   private void onIsInvisibleTo(PlayerEntity var1, CallbackInfoReturnable<Boolean> var2) {
      if (DaamkyClient.prepare()) {
         SeeInvisibles var3 = DaamkyClient.instance.data.handle(SeeInvisibles.class);
         if (var3 != null && var3.enabled) {
            MixinEntity var4 = this;
            if (!((Object)var4 instanceof ArmorStandEntity)) {
               var2.setReturnValue(false);
            }
         }
      }
   }
}
