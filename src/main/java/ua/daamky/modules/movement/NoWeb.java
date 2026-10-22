package ua.daamky.modules.movement;

import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.PlayerUpdateEvent;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.util.math.ClientMathUtil;
import ua.daamky.util.player.LocalhostHelper;
import ua.daamky.util.player.MovementPhysics;

@ModuleRegister(name = "NoWeb", description = "Убирает замедление в паутине", category = ModuleCategory.Movement)
public class NoWeb extends Module {
   @EventHandler
   public void handle(PlayerUpdateEvent var1) {
      if (!LocalhostHelper.handle() && LocalhostHelper.process()) {
         double[] var2 = MovementPhysics.handle((double)ClientMathUtil.compute(0.62F, 0.64F));
         Module.client.player.setVelocity(var2[0], Module.client.options.jumpKey.isPressed() ? 1.2 : (Module.client.options.sneakKey.isPressed() ? -2.0 : 0.0), var2[1]);
      }
   }
}
