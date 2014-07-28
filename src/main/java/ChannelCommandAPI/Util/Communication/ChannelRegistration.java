package ChannelCommandAPI.Util.Communication;

import ChannelCommandAPI.API.*;

import java.lang.reflect.*;

/**
 * Created by Ben Byers on 7/27/2014.
 */
public class ChannelRegistration {
    public ChannelRegistration(String channel, String subChannel, Method exec) {
        PluginRegister.getPlugin().getProxy().registerChannel(channel.toLowerCase());
        ChannelExecMap.addChannel(channel.toLowerCase(), subChannel, exec);
    }
}
