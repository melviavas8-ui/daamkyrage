package ua.daamky.render.shader;

import ua.daamky.gui.theme.BuiltinThemePresets;

public final class FoundryPresetFactory {
   private FoundryPresetFactory() {
   }

   public static ShaderGraph handle(ShaderNodeRegistry var0) {
      return BuiltinThemePresets.handle(var0);
   }
}
