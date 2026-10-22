package org.daamky.rpc;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
import ua.daamky.network.DiscordDisconnectCallback;
import ua.daamky.network.DiscordErrorCallback;
import ua.daamky.network.DiscordJoinGameCallback;
import ua.daamky.network.DiscordJoinRequestCallback;
import ua.daamky.network.DiscordReadyCallback;
import ua.daamky.network.DiscordSpectateCallback;

public class DiscordEventHandlers extends Structure {
   public DiscordDisconnectCallback disconnected;
   public DiscordJoinRequestCallback joinRequest;
   public DiscordSpectateCallback spectateGame;
   public DiscordReadyCallback ready;
   public DiscordErrorCallback errored;
   public DiscordJoinGameCallback joinGame;

   protected List<String> getFieldOrder() {
      return Arrays.asList("ready", "disconnected", "errored", "joinGame", "spectateGame", "joinRequest");
   }
}
