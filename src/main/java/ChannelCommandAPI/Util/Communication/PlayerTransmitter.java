package ChannelCommandAPI.Util.Communication;

import ChannelCommandAPI.API.*;
import com.google.common.io.*;
import net.md_5.bungee.api.connection.*;

import java.io.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/16/2014.
 */
public class PlayerTransmitter {

    public PlayerTransmitter(ProxiedPlayer player, String channel, String subChannel, ArrayList<String> message) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(); //Converted
        DataOutputStream data = new DataOutputStream(bytes); //Message will be
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        String server = player.getServer().getInfo().getName();
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

        player.sendData(channel, out.toByteArray());
    }
}
