package ua.daamky.modules.visuals;

import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.DaamkyClient;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.ModeSetting;
import ua.daamky.api.setting.NumberSetting;
import ua.daamky.gui.screen.AspectRatioMetrics;

@ModuleRegister(name = "AspectRation", description = "Изменяет разрешение экрана", category = ModuleCategory.Visuals)
public class AspectRation extends Module {
   public static final ModeSetting source = new ModeSetting(
      "Соотношение экрана", "16:9", "16:9", "4:3", "1:1", "16:10", "21:9", "32:9", "5:4", "2:1", "Кастомное"
   );
   public static final NumberSetting target = new NumberSetting("Кастомое значние", 2.0F, 1.0F, 3.0F, 0.1F, false).handle(() -> !source.process("Кастомное"));

   public AspectRation() {
      this.handle(source, target);
   }

   public static float refresh() {
      AspectRatioMetrics var0 = new AspectRatioMetrics(Module.client);
      if (!DaamkyClient.instance.data.process(AspectRation.class).enabled) {
         return 0.0F;
      }

      float var1 = (float)var0.compute() / var0.resolve();

      float var2 = switch (source.compute()) {
         case "16:9" -> 1.7777778F;
         case "4:3" -> 1.3333334F;
         case "1:1" -> 1.0F;
         case "16:10" -> 1.6F;
         case "21:9" -> 2.3333333F;
         case "32:9" -> 3.5555556F;
         case "5:4" -> 1.25F;
         case "2:1" -> 2.0F;
         default -> target.compute();
      };
      return var2 - var1;
   }
}
