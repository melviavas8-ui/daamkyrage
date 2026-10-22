package ua.daamky.modules.combat;

import net.minecraft.item.BowItem;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.daamky.module.api.Module;
import org.daamky.module.api.ModuleRegister;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.PlayerUpdateEvent;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.api.setting.NumberSetting;

@ModuleRegister(name = "FastBow", category = ModuleCategory.Combat, description = "Автоматический спам стрелами")
public class FastBow extends Module {
   private final NumberSetting source = new NumberSetting("Задержка", 10.0F, 1.0F, 10.0F, 1.0F, false);

   public FastBow() {
      this.handle(this.source);
   }

   @EventHandler
   public void handle(PlayerUpdateEvent var1) {
      if (!this.refresh()) {
         if (this.render()) {
            this.tick();
            Module.client.player.stopUsingItem();
         }
      }
   }

   private boolean refresh() {
      return Module.client.player == null || Module.client.world == null || Module.client.getNetworkHandler() == null;
   }

   private boolean render() {
      boolean var1 = Module.client.player.getMainHandStack().getItem() instanceof BowItem;
      boolean var2 = Module.client.player.isUsingItem();
      return var1 && var2 ? Module.client.player.getItemUseTime() >= this.source.compute() : false;
   }

   private void tick() {
      PlayerActionC2SPacket var1 = new PlayerActionC2SPacket(Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, Direction.DOWN);
      PlayerInteractItemC2SPacket var2 = new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, Module.client.player.getYaw(), Module.client.player.getPitch());
      Module.client.getNetworkHandler().sendPacket(var1);
      Module.client.getNetworkHandler().sendPacket(var2);
   }
}
