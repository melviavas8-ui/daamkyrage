package ua.daamky.modules.player;

import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.event.CameraClipEvent;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.module.ModuleCategory;

@ModuleRegister(name = "CameraClip", description = "Камера проходит сквозь блоки", category = ModuleCategory.Player)
public class CameraClip extends Module {
   @EventHandler
   public void handle(CameraClipEvent var1) {
      var1.process();
   }
}
