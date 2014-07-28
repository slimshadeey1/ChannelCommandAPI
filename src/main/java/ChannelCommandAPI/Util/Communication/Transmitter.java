package ChannelCommandAPI.Util.Communication;

import ChannelCommandAPI.API.*;
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

    public Transmitter(String channel, String subChannel, String server, ArrayList<String> message) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(); //Converted
        DataOutputStream data = new DataOutputStream(bytes); //Message will be
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        //Define Sub Channel
        out.writeUTF(subChannel);
        out.writeUTF(server);
        try {
            for (String s : message) {
                data.writeUTF(s);
            }
        } catch (IOException e) {
        }
        out.writeShort(bytes.toByteArray().length);
        out.write(bytes.toByteArray());

        plugin.getProxy().getServerInfo(server).sendData(channel, out.toByteArray());
    }
}

