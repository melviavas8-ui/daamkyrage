package ua.daamky.util.math;

public enum AnimationDirection {
   FORWARDS,
   BACKWARDS;

   public AnimationDirection handle() {
      return this == FORWARDS ? BACKWARDS : FORWARDS;
   }
}
