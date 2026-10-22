package ua.daamky.api.event;

public interface FrameRenderListener {
   void handle(int var1, int var2, float var3);

   default boolean handle() {
      return true;
   }
}
