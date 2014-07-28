package ChannelCommandAPI.API;

import ChannelCommandAPI.Util.Communication.*;
import net.md_5.bungee.api.plugin.*;

/**
 * Created by Ben Byers on 7/27/2014.
 */
public class PluginRegister {
    private static Plugin plugin;

    public PluginRegister(Plugin plug) {
        plugin = plug;
        plugin.getProxy().getPluginManager().registerListener(plugin, new Receiver());
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
