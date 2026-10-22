package org.daamky.mixin;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ua.daamky.modules.misc.Removals;

@Mixin(SoundManager.class)
public class SoundManagerMixin {
   @Inject(method = "play(Lnet/minecraft/client/sound/SoundInstance;)V", at = @At("HEAD"), cancellable = true, require = 0)
   private void daamky$mute(SoundInstance instance, CallbackInfo ci) {
      if (instance != null && Removals.handle(instance.getId())) ci.cancel();
   }
}
