package ua.daamky.modules.misc;

import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.PlayerUpdateEvent;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.BooleanSetting;
import ua.daamky.api.setting.ChoiceSetting;
import ua.daamky.api.setting.NumberSetting;
import ua.daamky.network.TelegramApi;
import ua.daamky.util.text.ChatLogger;

@ModuleRegister(name = "ClientUtil", category = ModuleCategory.Misc, description = "Настройки для клиента")
public class ClientUtil extends Module {
   public static final BooleanSetting source = new BooleanSetting("Уведомления в Telegram", true);
   public static final BooleanSetting target = new BooleanSetting("Звуки клиента", true);
   public static ChoiceSetting pending = new ChoiceSetting(
      "Звуки", new BooleanSetting("Модули", true), new BooleanSetting("Уведомления", true).handle(() -> !target.compute())
   );
   public static NumberSetting previous = new NumberSetting("Громкость", 100.0F, 10.0F, 100.0F, 1.0F, false).handle(() -> !target.compute());

   public ClientUtil() {
      this.handle(source, target, pending, previous);
   }

   @EventHandler
   public void handle(PlayerUpdateEvent var1) {
      if (source.compute() && !TelegramApi.handle()) {
         ChatLogger.handle("§cСписок пуст для отправки сообщений. Настройте API через .tapi");
         source.process(false);
      }
   }
}
