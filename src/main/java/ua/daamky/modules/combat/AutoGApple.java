package ua.daamky.modules.combat;

import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.PlayerUpdateEvent;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.NumberSetting;

@ModuleRegister(name = "AutoGApple", category = ModuleCategory.Combat, description = "Автоматически есть яблочки")
public class AutoGApple extends Module {
   public final NumberSetting source = new NumberSetting("Здоровье", 10.0F, 1.0F, 20.0F, 1.0F, false);

   public AutoGApple() {
      this.handle(this.source);
   }

   @EventHandler
   public void handle(PlayerUpdateEvent var1) {
   }
}
