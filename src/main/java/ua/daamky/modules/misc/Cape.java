package ua.daamky.modules.misc;

import com.mojang.authlib.GameProfile;
import java.util.function.Consumer;
import net.minecraft.util.Identifier;
import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.module.ModuleRoles;

@ModuleRoles(compute = "lichoday")
@ModuleRegister(name = "Cape", category = ModuleCategory.Misc, description = "Добавляет вам плащик")
public class Cape extends Module {
   public static void handle(GameProfile var0, Consumer<Identifier> var1) {
   }
}
