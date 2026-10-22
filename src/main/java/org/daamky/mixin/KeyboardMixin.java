package org.daamky.mixin;

import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ua.daamky.DaamkyClient;
import ua.daamky.api.event.EventHandlerInvoker;
import ua.daamky.api.event.InputButtonEvent;
import ua.daamky.core.EventDispatchBoundary;
import ua.daamky.gui.screen.ClickGuiModernScreen;
import ua.daamky.gui.screen.ServerPresets;
import ua.daamky.modules.misc.AutoBuy;
import ua.daamky.modules.misc.Removals;
import ua.daamky.modules.misc.UnHook;
import ua.daamky.modules.visuals.Menu;
import ua.daamky.util.inventory.AutoBuyItemResolver;

@Mixin(Keyboard.class)
public class KeyboardMixin {
   @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
   private void handleMenuKeyEvent(long var1, int var3, int var4, int var5, int var6, CallbackInfo var7) {
      if (DaamkyClient.prepare()) {
         EventDispatchBoundary.handle();
         if (UnHook.target) {
            if (var5 == 1 && var3 == 344 && (var6 & 2) != 0) {
               var7.cancel();
            }
         } else if (Removals.refresh() && var5 == 1 && var3 == 66 && (var6 & 2) != 0) {
            var7.cancel();
         } else if (DaamkyClient.drawProfile() && DaamkyClient.instance != null) {
            MinecraftClient var8 = MinecraftClient.getInstance();
            if (var8 != null && var8.getWindow() != null) {
               if (var5 == 1 && var3 == 67 && (var6 & 2) != 0 && (var6 & 4) != 0 && AutoBuyItemResolver.handle(var8)) {
                  var7.cancel();
               } else if (var8.currentScreen == null) {
                  if (isWindowInputUsable(var8, var1)) {
                     InputButtonEvent var9 = new InputButtonEvent(var1, var3, var4, var5, var6);
                     EventHandlerInvoker.handle(var9);
                     if (!var9.handle() && var9.apply() == 1 && var8.currentScreen == null) {
                        AutoBuy var10 = DaamkyClient.instance.data.handle(AutoBuy.class);
                        if (var10 != null && var10.frameCheck.compute() != -1 && var9.resolve() == var10.frameCheck.compute()) {
                           var8.setScreen(new ServerPresets());
                           if (var8.mouse != null) {
                              var8.mouse.unlockCursor();
                           }

                           var9.process();
                        }

                        Menu var11 = Menu.drawAnimation();
                        int var12 = var11 != null && var11.keyCode != -1 ? var11.keyCode : 344;
                        if (var12 != -1 && var9.resolve() == var12) {
                           ClickGuiModernScreen var13 = DaamkyClient.instance.resolve();
                           if (var13 != null) {
                              var8.setScreen(var13);
                              if (var8.mouse != null) {
                                 var8.mouse.unlockCursor();
                              }

                              var9.process();
                           }
                        }
                     }

                     if (var9.handle()) {
                        var7.cancel();
                     }
                  }
               }
            }
         }
      }
   }

   private static boolean isWindowInputUsable(MinecraftClient var0, long var1) {
      if (var0 != null && var0.getWindow() != null && var1 != 0L && var0.isWindowFocused()) {
         Window var3 = var0.getWindow();
         return var1 == var3.getHandle() && !var3.hasZeroWidthOrHeight() && var3.getFramebufferWidth() > 0 && var3.getFramebufferHeight() > 0;
      } else {
         return false;
      }
   }
}
