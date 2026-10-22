package ua.daamky.modules.misc;

import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.PacketEvent;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.StringSetting;
import ua.daamky.util.world.ServerEnvironment;

@ModuleRegister(name = "AutoAuth", description = "Авто регистр/логин на серверах", category = ModuleCategory.Misc)
public class AutoAuth extends Module {
   public final StringSetting source = new StringSetting("Пишите сюда ваш пороль", "");

   public AutoAuth() {
      this.handle(this.source);
   }

   @EventHandler
   public void handle(PacketEvent var1) {
      if (!ServerEnvironment.handle() && Module.client.world != null) {
         if (var1.resolve() instanceof GameMessageS2CPacket var2) {
            String var5 = var2.content().getString();
            String var4 = this.source.compute();
            if ((var5.contains("Войдите") || var5.contains("/login")) && Module.client.player.networkHandler != null) {
               Module.client.player.networkHandler.sendChatCommand("login " + var4);
            }

            if ((var5.contains("Зарегистрируйтесь") || var5.contains("/reg")) && var4 != null && var4.length() >= 4 && Module.client.player.networkHandler != null
               )
             {
               Module.client.player.networkHandler.sendChatCommand("reg " + var4 + " " + var4);
            }
         }
      }
   }
}
