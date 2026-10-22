package ua.daamky.modules.player;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.item.Items;
import org.daamky.mixin.acceser.ClientPlayerInteractionManagerAccessor;
import org.daamky.mixin.acceser.MinecraftClientAccessor;
import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.PlayerUpdateEvent;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.BooleanSetting;
import ua.daamky.api.setting.NumberSetting;

@ModuleRegister(name = "NoDelay", description = "Убирает задержку", category = ModuleCategory.Player)
public class NoDelay extends Module {
   public static BooleanSetting source = new BooleanSetting("Прыжки", true);
   public static BooleanSetting target = new BooleanSetting("Рандомизация", false).handle(() -> !source.compute());
   public static BooleanSetting pending = new BooleanSetting("Поломка блоков", false);
   public static BooleanSetting previous = new BooleanSetting("ЛКМ", false);
   public static BooleanSetting latest = new BooleanSetting("ПКМ", false);
   public static BooleanSetting summary = new BooleanSetting("Пузырьки опыта", true);
   public static NumberSetting matrixBlend = new NumberSetting("Скорость прыжка", 0.0F, 0.0F, 10.0F, 1.0F, false).handle(() -> !source.compute());
   public static NumberSetting vectorMatch = new NumberSetting("Скорость поломки блока", 0.0F, 0.0F, 5.0F, 1.0F, false).handle(() -> !pending.compute());
   public static NumberSetting itemProject = new NumberSetting("ЛКМ задержка", 0.0F, 0.0F, 10.0F, 1.0F, false).handle(() -> !previous.compute());
   public static NumberSetting responseCompute = new NumberSetting("ПКМ задержка", 0.0F, 0.0F, 4.0F, 1.0F, false).handle(() -> !latest.compute());

   public NoDelay() {
      this.handle(source, target, matrixBlend, pending, vectorMatch, previous, itemProject, latest, responseCompute, summary);
   }

   public static int refresh() {
      int var0 = (int)matrixBlend.compute();
      return target.compute() && var0 > 0 ? ThreadLocalRandom.current().nextInt(0, var0 + 1) : var0;
   }

   @EventHandler
   public void handle(PlayerUpdateEvent var1) {
      if (Module.client.player != null) {
         if (pending.compute() && Module.client.interactionManager != null) {
            ClientPlayerInteractionManagerAccessor var2 = (ClientPlayerInteractionManagerAccessor)Module.client.interactionManager;
            if (var2.getBlockBreakingCooldown() > vectorMatch.compute()) {
               var2.setBlockBreakingCooldown((int)vectorMatch.compute());
            }
         }

         if (summary.compute()) {
            boolean var3 = Module.client.player.getMainHandStack().getItem() == Items.EXPERIENCE_BOTTLE
               || Module.client.player.getOffHandStack().getItem() == Items.EXPERIENCE_BOTTLE;
            if (var3) {
               ((MinecraftClientAccessor)Module.client).setItemUseCooldown(0);
            }
         }
      }
   }

   @Override
   public void process() {
      super.process();
      if (Module.client.interactionManager != null) {
         ((ClientPlayerInteractionManagerAccessor)Module.client.interactionManager).setBlockBreakingCooldown(5);
      }
   }
}
