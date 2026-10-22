package ua.daamky.config;

import java.util.ArrayList;
import java.util.List;
import ua.daamky.sdk.Compile;
import ua.daamky.sdk.Loader;

public abstract class ConfigStore<T> {
   private List<T> instance = new ArrayList<>();

   public List<T> apply() {
      return this.instance;
   }

   @Compile
   public void handle(ArrayList<T> var1) {
      this.instance = var1;
   }

   static {
      Loader.initialize();
   }
}
