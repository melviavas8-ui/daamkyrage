package ua.daamky.config;

import ua.daamky.profile.Profile;

public final class HudProfileGate {
   private static final String[] instance = new String[]{"lichoday"};

   private HudProfileGate() {
   }

   public static boolean handle() {
      return Profile.isUsername(instance);
   }
}
