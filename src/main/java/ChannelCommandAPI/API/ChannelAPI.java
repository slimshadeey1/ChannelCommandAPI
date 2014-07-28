package ChannelCommandAPI.API;

import ChannelCommandAPI.API.Interfaces.*;
import ChannelCommandAPI.Util.Communication.*;
import net.md_5.bungee.api.connection.*;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/26/2014.
 */
public class ChannelAPI {
    public ChannelAPI(Exec exec) {
        for (Method method : exec.getClass().getMethods()) {
            try {
                ChannelInt channel = method.getAnnotation(ChannelInt.class);
                new ChannelRegistration(channel.channel(), channel.subchannel(), method);
            } catch (Exception e) {
            }
        }
    }

    public static void SendServer(String Channel, String SubChannel, String Server, ArrayList<String> Data) {
        new Transmitter(Channel, SubChannel, Server, Data);
    }

    public static void SendPlayer(String Channel, String SubChannel, ProxiedPlayer Player, ArrayList<String> Data) {
        new PlayerTransmitter(Player, Channel, SubChannel, Data);
    }
}

