package ua.daamky.command;

import ua.daamky.core.Command;
import ua.daamky.sdk.Compile;
import ua.daamky.sdk.Loader;
import ua.daamky.util.text.ChatLogger;

public class HelpCommand extends Command {
   private final CommandManager instance;

   public HelpCommand(CommandManager var1) {
      super("help", "Показывает список всех команд", ".help");
      this.instance = var1;
   }

   @Compile
   @Override
   public void process(String[] var1) {
      ChatLogger.handle("§bДоступные команды:");

      for (Command var3 : this.instance.handle()) {
         ChatLogger.handle("§7" + var3.compute() + " §8- §f" + var3.process());
      }
   }

   static {
      Loader.initialize();
   }
}
