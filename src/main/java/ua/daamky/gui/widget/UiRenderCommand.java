package ua.daamky.gui.widget;

import ua.daamky.gui.screen.ModernClickGuiState;

@FunctionalInterface
public interface UiRenderCommand {
   void execute(ModernClickGuiState var1);
}
