package ua.daamky.modules.movement;

import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.PlayerUpdateEvent;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.NumberSetting;
import ua.daamky.util.player.MovementPhysics;
import ua.daamky.util.world.ServerEnvironment;

@ModuleRegister(name = "DragonFly", category = ModuleCategory.Movement, description = "Ускоряет вас в воздухе")
public class DragonFly extends Module {
   public final NumberSetting source = new NumberSetting("Скорость по X", 1.0F, 1.0F, 100.0F, 1.0F, false);
   public final NumberSetting target = new NumberSetting("Скорость по Y", 1.0F, 1.0F, 100.0F, 1.0F, false);

   public DragonFly() {
      this.handle(this.source, this.target);
   }

   @EventHandler
   public void handle(PlayerUpdateEvent var1) {
      if (!ServerEnvironment.handle()) {
         if (Module.client.player.getAbilities().flying) {
            double var2 = this.source.compute() / 10.0;
            double var4 = this.target.compute() / 10.0;
            double var6;
            if (Module.client.options.jumpKey.isPressed()) {
               var6 = var4;
            } else if (Module.client.options.sneakKey.isPressed()) {
               var6 = -var4;
            } else {
               var6 = 0.0;
            }

            if (MovementPhysics.handle()) {
               double[] var8 = MovementPhysics.handle(var2);
               Module.client.player.setVelocity(var8[0], var6, var8[1]);
            } else {
               Module.client.player.setVelocity(0.0, var6, 0.0);
            }
         }
      }
   }
}
