package ChannelCommandAPI.API;

import ChannelCommandAPI.API.Interfaces.*;
import ChannelCommandAPI.Objects.*;
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

    public static void SendServer(BAout data) {
        new Transmitter(data);
    }

    public static void SendPlayer(ProxiedPlayer player, BAout data) {
        new PlayerTransmitter(player, data);
    }
}

