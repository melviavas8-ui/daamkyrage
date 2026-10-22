package ua.daamky.modules.misc;

import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.NumberSetting;

@ModuleRegister(name = "SeeInvisibles", category = ModuleCategory.Misc, description = "Показ игроков в невидимости")
public class SeeInvisibles extends Module {
   public final NumberSetting source = new NumberSetting("Прозрачность", 0.5F, 0.3F, 1.0F, 0.1F, false);

   public SeeInvisibles() {
      this.handle(this.source);
   }
}
