package ua.daamky.gui.screen;

import ua.daamky.render.BlurStateManager;
import ua.daamky.util.math.EasingFunctions;

public class ClickGuiOpenTransition extends BlurStateManager {
   public static void process() {
      BlurStateManager.active = BlurStateManager.active.handle(1.0, 0.2F);
      BlurStateManager.mode.apply(0.0);
      BlurStateManager.mode.handle(1.0, 0.4F, EasingFunctions.summary);
      BlurStateManager.moduleCollect = false;
      BlurStateManager.data.compute();
      BlurStateManager.current.handle(1.0);
   }
}
