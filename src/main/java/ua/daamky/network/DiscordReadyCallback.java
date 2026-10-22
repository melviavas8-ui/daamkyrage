package ua.daamky.network;

import com.sun.jna.Callback;
import org.daamky.rpc.DiscordUser;

public interface DiscordReadyCallback extends Callback {
   void apply(DiscordUser var1);
}
