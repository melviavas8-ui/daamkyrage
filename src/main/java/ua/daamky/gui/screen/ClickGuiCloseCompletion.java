package ua.daamky.gui.screen;

import ua.daamky.render.BlurStateManager;

public class ClickGuiCloseCompletion extends BlurStateManager {
   public static void process() {
      if (BlurStateManager.moduleCollect && BlurStateManager.mode.compute()) {
         BlurStateManager.moduleCollect = false;
      }
   }
}
