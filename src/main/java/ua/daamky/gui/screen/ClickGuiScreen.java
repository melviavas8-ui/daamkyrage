package ua.daamky.gui.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import ua.daamky.DaamkyClient;
import ua.daamky.api.event.EventHandler;
import ua.daamky.api.event.EventHandlerInvoker;
import ua.daamky.api.event.GuiRenderContext;
import ua.daamky.api.module.ModuleCategory;
import ua.daamky.core.manager.FeatureManager;
import ua.daamky.gui.theme.ThemeManager;
import ua.daamky.gui.theme.ThemePalette;
import ua.daamky.gui.widget.PanelHitTest;
import ua.daamky.gui.widget.ScrollRegionHitTest;
import ua.daamky.gui.widget.TextInputFilter;
import ua.daamky.render.BlurStateManager;
import ua.daamky.util.math.EasingFunctions;
import ua.daamky.util.player.SyntheticKeyState;
import ua.daamky.util.render.RoundedRectRenderer;

public class ClickGuiScreen extends Screen {
   public ClickGuiBackdropRenderer instance;
   public MinecraftClient data = MinecraftClient.getInstance();
   private static volatile boolean context = false;

   public ClickGuiScreen() {
      super(Text.literal("Gui"));
   }

   public static void handle() {
      if (!context) {
         context = true;
         EventHandlerInvoker.handle(new Object() {
            @EventHandler
            public void handle(GuiRenderContext var1) {
               MinecraftClient var2 = var1.compute();
               if (var2 != null && var2.currentScreen instanceof ClickGuiScreen) {
                  double[] var3 = new double[1];
                  double[] var4 = new double[1];
                  if (var2.getWindow() != null) {
                     GLFW.glfwGetCursorPos(var2.getWindow().getHandle(), var3, var4);
                     if (var2.mouse != null) {
                        var2.mouse.unlockCursor();
                     }
                  }

                  int var5 = (int)var3[0];
                  int var6 = (int)var4[0];
                  Object var7 = null;
                  ClickGuiRenderer.handle(var1.resolve(), (DrawContext)var7, var5, var6, var2.getRenderTickCounter().getDynamicDeltaTicks());
               }
            }
         });
      }
   }

   public void render(DrawContext var1, int var2, int var3, float var4) {
   }

   public void renderBackground(DrawContext var1, int var2, int var3, float var4) {
   }

   public void renderInGameBackground(DrawContext var1) {
   }

   public boolean mouseClicked(double var1, double var3, int var5) {
      RoundedRectRenderer var6 = DaamkyClient.handle();
      return var6 != null && ModuleCategoryPanel.handle(var6, var1, var3, var5) ? true : true;
   }

   public boolean mouseReleased(double var1, double var3, int var5) {
      ClickGuiFrameReset.process();
      return true;
   }

   public boolean mouseDragged(double var1, double var3, int var5, double var6, double var8) {
      return ScrollRegionHitTest.handle(var1, var3, var5, var6, var8) ? true : true;
   }

   public boolean mouseScrolled(double var1, double var3, double var5, double var7) {
      if (Math.abs(var7) > 1.0E-4) {
         int var9 = var7 > 0.0 ? -200 : -201;
         if (BlurStateManager.previous != null) {
            BlurStateManager.previous.config = var9;
            BlurStateManager.previous.output = false;
            BlurStateManager.previous = null;
            if (DaamkyClient.instance.renderer != null) {
               DaamkyClient.instance.renderer.compute();
            }

            return true;
         }

         if (BlurStateManager.matrixBlend != null) {
            BlurStateManager.matrixBlend.keyCode = var9;
            BlurStateManager.matrixBlend.bindingActive = false;
            BlurStateManager.compute(BlurStateManager.matrixBlend).handle(1.0, 0.2F, EasingFunctions.pending);
            BlurStateManager.matrixBlend = null;
            if (DaamkyClient.instance.renderer != null) {
               DaamkyClient.instance.renderer.compute();
            }

            return true;
         }
      }

      return ModuleCategoryPanel.handle(var1, var3, var7) ? true : true;
   }

   public boolean keyPressed(int var1, int var2, int var3) {
      return PanelHitTest.handle(var1, var2, var3) ? true : super.keyPressed(var1, var2, var3);
   }

   public boolean charTyped(char var1, int var2) {
      return TextInputFilter.handle(var1, var2) ? true : super.charTyped(var1, var2);
   }

   public boolean shouldCloseOnEsc() {
      return ClickGuiCloseTransition.process();
   }

   public void close() {
      SyntheticKeyState.handle().process("Search");
      BlurStateManager.profileDraw = false;
      BlurStateManager.providerFetch = "";
      DaamkyClient.instance.selection.handle(BlurStateManager.sourceSchedule);
      super.close();
   }

   public void tick() {
      super.tick();
      if (BlurStateManager.moduleCollect && BlurStateManager.mode.compute()) {
         this.close();
         BlurStateManager.moduleCollect = false;
      }
   }

   public boolean shouldPause() {
      return false;
   }

   public void init() {
      super.init();
      this.instance = new ClickGuiBackdropRenderer();
      ClickGuiOpenTransition.process();
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1 != null && var1.mouse != null) {
         var1.mouse.unlockCursor();
      }

      BlurStateManager.rendererScan = ModuleCategory.values();
      BlurStateManager.profileInvoke = ThemePalette.values();
      BlurStateManager.windowConvert = 366.475F;
      BlurStateManager.presetWrite = 238.805F;
      BlurStateManager.providerClose = 480.0F - BlurStateManager.windowConvert / 2.0F;
      BlurStateManager.presetSave = 260.0F - BlurStateManager.presetWrite / 2.0F;
      BlurStateManager.data.compute();
      if (DaamkyClient.instance.selection == null) {
         DaamkyClient.instance.selection = new ThemeManager();
         DaamkyClient.instance.selection.handle();
      }

      BlurStateManager.sourceBuild = DaamkyClient.instance.selection.process();
      BlurStateManager.outputCollapse = DaamkyClient.instance.selection.process();
      BlurStateManager.sourceSchedule = DaamkyClient.instance.selection.compute();
      if (DaamkyClient.instance.data == null) {
         DaamkyClient.instance.data = new FeatureManager();
      }

      BlurStateManager.timerRender = DaamkyClient.instance.data.handle(BlurStateManager.sourceSchedule);
   }
}
