package ua.daamky.api.event;

public class MutableRenderDeltaEvent extends Event {
   float instance;

   public float compute() {
      return this.instance;
   }

   public float handle(float var1) {
      return this.instance = var1;
   }
}
