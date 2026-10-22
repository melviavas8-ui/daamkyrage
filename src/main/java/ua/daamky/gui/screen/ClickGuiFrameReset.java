package ua.daamky.gui.screen;

import ua.daamky.DaamkyClient;
import ua.daamky.render.BlurStateManager;

public class ClickGuiFrameReset extends BlurStateManager {
   public static void process() {
      if ((BlurStateManager.summary != null || BlurStateManager.source || BlurStateManager.target || BlurStateManager.pending)
         && DaamkyClient.instance.renderer != null) {
         DaamkyClient.instance.renderer.compute();
      }

      BlurStateManager.source = false;
      BlurStateManager.target = false;
      BlurStateManager.pending = false;
      BlurStateManager.summary = null;
      BlurStateManager.vectorMatch = 0.0F;
      BlurStateManager.itemProject = 0.0F;
      BlurStateManager.responseCompute = 0.0F;
   }
}
