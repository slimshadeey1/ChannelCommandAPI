package ChannelCommandAPI.Util.Communication;

import ChannelCommandAPI.API.*;
import ChannelCommandAPI.Objects.*;
import com.google.common.io.*;
import net.md_5.bungee.api.plugin.*;

import java.io.*;
import java.util.*;

/**
 * Beta
 * Created by Ben Byers on 7/15/2014.
 */
public class Transmitter {
    /* Perform Transmitting */
    private Plugin plugin = PluginRegister.getPlugin();

    public Transmitter(BAout packet) {
        plugin.getProxy().getServerInfo(packet.getServer()).sendData(packet.getChannel(), packet.getPacket().toByteArray());
    }
}

