package ua.daamky.modules.misc;

import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.BooleanSetting;
import ua.daamky.api.setting.ChoiceSetting;
import ua.daamky.util.player.NicknameUtil;

@ModuleRegister(name = "LockSlots", category = ModuleCategory.Misc, description = "Блокирует выкидывание выбранных слотов хотбара")
public class LockSlots extends Module {
   public final ChoiceSetting source = new ChoiceSetting(
      "Слоты: ",
      new BooleanSetting("1", false),
      new BooleanSetting("2", false),
      new BooleanSetting("3", false),
      new BooleanSetting("4", false),
      new BooleanSetting("5", false),
      new BooleanSetting("6", false),
      new BooleanSetting("7", false),
      new BooleanSetting("8", false),
      new BooleanSetting("9", false)
   );
   private final BooleanSetting target = new BooleanSetting("Работать только в КД", false);

   public LockSlots() {
      this.handle(this.source, this.target);
   }

   public boolean handle(int var1) {
      if (var1 < 0 || var1 > 8) {
         return false;
      } else {
         return !this.refresh() ? false : this.source.handle(var1);
      }
   }

   private boolean refresh() {
      return !this.target.compute() || NicknameUtil.process();
   }
}
