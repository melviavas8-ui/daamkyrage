package ua.daamky.network;

import com.sun.jna.Callback;
import org.daamky.rpc.DiscordUser;

public interface DiscordJoinRequestCallback extends Callback {
   void handle(DiscordUser var1);
}
