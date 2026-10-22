package ua.daamky.api.event;

public class Cancellable implements CancellationContract {
   private boolean instance;

   @Override
   public boolean handle() {
      return this.instance;
   }

   @Override
   public void process() {
      this.instance = true;
   }
}
