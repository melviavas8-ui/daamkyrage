package ua.daamky.gui.hud;

import ua.daamky.gui.theme.LivePreviewRenderer;

public interface HudElementRenderer {
   LivePreviewRenderer compute();

   default String resolve() {
      return null;
   }

   default boolean update() {
      return false;
   }
}
