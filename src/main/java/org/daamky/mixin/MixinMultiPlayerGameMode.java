package org.daamky.mixin;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ua.daamky.DaamkyClient;
import ua.daamky.api.event.EntityAttackEvent;
import ua.daamky.api.event.EventHandlerInvoker;
import ua.daamky.modules.misc.FriendManager;
import ua.daamky.modules.player.FakePlayer;

@Mixin(ClientPlayerInteractionManager.class)
public class MixinMultiPlayerGameMode {
   @Inject(method = "attackEntity", at = @At("HEAD"), cancellable = true)
   private void onAttack(PlayerEntity var1, Entity var2, CallbackInfo var3) {
      if (DaamkyClient.prepare()) {
         EntityAttackEvent var4 = new EntityAttackEvent(var2);
         EventHandlerInvoker.handle(var4);
         if (var4.handle()) {
            var3.cancel();
         } else if (FakePlayer.handle(var2)) {
            var3.cancel();
         } else {
            if (var2 instanceof PlayerEntity) {
               String var5 = var2.getName().getString();
               FriendManager var6 = DaamkyClient.instance.data.handle(FriendManager.class);
               if (var6 != null && var6.enabled && FriendManager.target.compute() && ua.daamky.core.manager.FriendManager.handle(var5)) {
                  var3.cancel();
               }
            }
         }
      }
   }
}
