package ChannelCommandAPI.Util.Communication;

import ChannelCommandAPI.API.*;
import ChannelCommandAPI.Objects.*;
import com.google.common.io.*;
import net.md_5.bungee.api.connection.*;

import java.io.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/16/2014.
 */
public class PlayerTransmitter {

    public PlayerTransmitter(ProxiedPlayer player, BAout packet) {
        player.sendData(packet.getChannel(), packet.getPacket().toByteArray());
    }
}
