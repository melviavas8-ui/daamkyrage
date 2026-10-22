package ua.daamky.modules.combat;

import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.PacketEvent;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.module.ModuleFlag;
import ua.daamky.api.setting.ModeSetting;
import ua.daamky.util.player.LocalhostHelper;

@ModuleRegister(
   name = "Velocity",
   description = "Убирает откидывание",
   category = ModuleCategory.Combat,
   flags = {ModuleFlag.RISKY, ModuleFlag.MATRIX, ModuleFlag.GRIM}
)
public class Velocity extends Module {
   public static ModeSetting source = new ModeSetting("Обход", "Vanilla", "Vanilla", "Lag", "Funtime");

   public Velocity() {
      this.handle(source);
   }

   @EventHandler
   public void handle(PacketEvent var1) {
      if (!LocalhostHelper.handle()) {
         if (source.process("Vanilla") && var1.resolve() instanceof EntityVelocityUpdateS2CPacket var2 && var2.getEntityId() == Module.client.player.getId()) {
            var1.process();
         }

         if (source.process("Funtime")
            && var1.resolve() instanceof EntityVelocityUpdateS2CPacket var4
            && var4.getEntityId() == Module.client.player.getId()
            && Module.client.player.inPowderSnow) {
            var1.process();
         }

         if (source.process("Lag")) {
            if (var1.resolve() instanceof EntityVelocityUpdateS2CPacket var5 && var5.getEntityId() == Module.client.player.getId()) {
               var1.process();
            }

            if (var1.compute()) {
               var1.process();
            }
         }
      }
   }
}
