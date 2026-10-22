package ua.daamky.gui.widget;

import org.daamky.module.api.Module;
import ua.daamky.api.setting.Setting;

@FunctionalInterface
public interface SettingPopupHost {
   void openForSetting(Module var1, Setting var2, double var3, double var5, Object var7);
}
