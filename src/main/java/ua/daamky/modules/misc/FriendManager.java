package ua.daamky.modules.misc;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.DaamkyClient;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.InputButtonEvent;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.BooleanSetting;
import ua.daamky.api.setting.KeybindSetting;
import ua.daamky.audio.AudioResourceManager;
import ua.daamky.modules.combat.AttackAura;
import ua.daamky.util.math.ActionDelay;

@ModuleRegister(name = "FriendManager", category = ModuleCategory.Misc, description = "Менеджер по управлению в друзьях")
public class FriendManager extends Module {
   public static KeybindSetting source = new KeybindSetting("Бинд друзей", -1);
   public static BooleanSetting target = new BooleanSetting("Не бить друзей", true);
   public static BooleanSetting pending = new BooleanSetting("Убирать хитбокс друга", true);
   private final ActionDelay previous = new ActionDelay();

   public FriendManager() {
      this.handle(source, target, pending);
   }

   @EventHandler
   public void handle(InputButtonEvent var1) {
      if (var1.resolve() == source.compute() && var1.apply() == 1 && this.previous.resolve(200L)) {
         if (AttackAura.textureRun != null) {
            return;
         }

         HitResult var2 = Module.client.crosshairTarget;
         if (var2 == null || var2.getType() != Type.ENTITY) {
            return;
         }

         if (!(((EntityHitResult)var2).getEntity() instanceof PlayerEntity var4)) {
            return;
         }

         String var5 = var4.getName().getString();
         String var6 = DaamkyClient.instance.fetchProvider();
         if (!ua.daamky.core.manager.FriendManager.handle(var5)) {
            DaamkyClient.instance.projectItem().handle(var6 + "friend add " + var5);
            AudioResourceManager.handle("add", 0.5F);
         } else {
            DaamkyClient.instance.projectItem().handle(var6 + "friend remove " + var5);
            AudioResourceManager.handle("remove", 0.5F);
         }

         this.previous.handle();
      }
   }
}
