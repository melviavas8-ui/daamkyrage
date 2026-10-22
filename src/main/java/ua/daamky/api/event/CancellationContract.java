package ua.daamky.api.event;

public interface CancellationContract {
   boolean handle();

   void process();
}
