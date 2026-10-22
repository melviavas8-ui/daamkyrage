package ua.daamky.command;

import java.util.Locale;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import ua.daamky.DaamkyClient;
import ua.daamky.api.setting.BooleanSetting;
import ua.daamky.core.Command;
import ua.daamky.core.manager.FeatureManager;
import ua.daamky.modules.misc.AhHelper;
import ua.daamky.sdk.Compile;
import ua.daamky.sdk.Loader;
import ua.daamky.util.text.ChatLogger;

public final class AuctionPageCommand extends Command {
   public AuctionPageCommand() {
      super("ah", "Открыть общую страницу аукциона с фильтром цены", ".ah [максимальная цена]");
   }

   @Compile
   @Override
   public void process(String[] var1) {
      if (toggleState.player == null || toggleState.player.networkHandler == null) {
         ChatLogger.handle("§c[AhHelper] Игрок не подключен к серверу.");
      } else if (var1.length == 0) {
         AhHelper.refresh();
         ClientPlayNetworkHandler var6 = toggleState.player.networkHandler;
         if (var6 != null) {
            var6.sendChatCommand("ah");
         }
      } else {
         Long var2 = this.compute(var1);
         if (var2 != null && var2 > 0L) {
            if (DaamkyClient.instance != null && DaamkyClient.instance.data != null) {
               FeatureManager var3 = DaamkyClient.instance.data;
               if (var3 != null) {
                  AhHelper var4 = var3.handle(AhHelper.class);
                  if (var4 != null && !var4.enabled) {
                     var4.setEnabled(true);
                  }
               }
            }

            AhHelper.handle(var2);
            ClientPlayNetworkHandler var7 = toggleState.player.networkHandler;
            if (var7 != null) {
               var7.sendChatCommand("ah");
            }

            BooleanSetting var8 = AhHelper.pending;
            String var5 = var8 != null && var8.compute() ? "§aвключен" : "§eзадан, чекбокс выключен";
            ChatLogger.handle("§7[AhHelper] Общий фильтр " + var5 + "§7: до §f" + this.handle(var2) + "$");
         } else {
            ChatLogger.handle("§cИспользование: " + this.handle());
            ChatLogger.handle("§7Пример: §f.ah 100 000");
         }
      }
   }

   private Long compute(String[] var1) {
      StringBuilder var2 = new StringBuilder();

      for (String var6 : var1) {
         if (var6 == null || !var6.matches("[0-9][0-9_.,]*")) {
            return null;
         }

         var2.append(var6.replaceAll("[^0-9]", ""));
      }

      if (var2.isEmpty()) {
         return null;
      }

      try {
         return Long.parseLong(var2.toString());
      } catch (NumberFormatException var7) {
         return null;
      }
   }

   private String handle(long var1) {
      return String.format(Locale.ROOT, "%,d", var1).replace(',', ' ');
   }

   static {
      Loader.initialize();
   }
}
