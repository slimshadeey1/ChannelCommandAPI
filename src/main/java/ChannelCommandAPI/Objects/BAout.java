package ChannelCommandAPI.Objects;

import com.google.common.io.*;

import java.io.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/30/2014.
 */
public class BAout {
    private String Channel;
    private String SubChannel;
    private String Server = "ALL";
    private ArrayList<String> Data = new ArrayList<>();
    private ByteArrayDataOutput Packet;

    public BAout(String channel, String subchannel) {
        Channel = channel;
        SubChannel = subchannel;
    }

    public void setData(ArrayList<String> data) {
        Data = data;
    }

    public void setServer(String server) {
        Server = server;
    }

    public ByteArrayDataOutput getPacket() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(); //Converted
        DataOutputStream data = new DataOutputStream(bytes); //Message will be
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        //Define Sub Channel
        out.writeUTF(SubChannel);
        out.writeUTF(Server);
        try {
            for (String s : Data) {
                data.writeUTF(s);
            }
        } catch (IOException e) {
        }
        out.writeShort(bytes.toByteArray().length);
        out.write(bytes.toByteArray());
        Packet = out;
        return Packet;
    }

    public String getChannel() {
        return Channel;
    }

    public String getSubChannel() {
        return SubChannel;
    }

    public String getServer() {
        return Server;
    }
}
