package ua.daamky.core.manager;

import java.util.HashMap;
import ua.daamky.api.event.EventHandlerInvoker;
import ua.daamky.automation.RotationController;
import ua.daamky.core.ClientComponent;
import ua.daamky.core.InteractionStateTracker;
import ua.daamky.core.RotationDebugProbe;
import ua.daamky.core.ViewRotationCoordinator;

public final class ClientComponentRegistry extends HashMap<Class<? extends ClientComponent>, ClientComponent> {
   public void handle() {
      this.handle(new ViewRotationCoordinator(), new RotationController(), new InteractionStateTracker(), new RotationDebugProbe());
      this.values().forEach(var0 -> EventHandlerInvoker.handle(var0));
   }

   public void handle(ClientComponent... var1) {
      for (ClientComponent var5 : var1) {
         this.put((Class<? extends ClientComponent>)var5.getClass(), var5);
      }
   }

   public void process(ClientComponent... var1) {
      for (ClientComponent var5 : var1) {
         EventHandlerInvoker.process(var5);
         this.remove(var5.getClass());
      }
   }

   public <T extends ClientComponent> T handle(Class<T> var1) {
      return this.values().stream().filter(var1x -> var1x.getClass() == var1).map(var1::cast).findFirst().orElse(null);
   }
}
