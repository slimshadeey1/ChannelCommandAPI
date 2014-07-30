package ChannelCommandAPI.Objects;

import java.io.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/30/2014.
 */
public class BAin {
    private ArrayList<String> dat;
    private String server;
    private String subChannel;

    public BAin(DataInputStream in) {
        try {
            subChannel = in.readUTF();
            server = in.readUTF();
            short len = in.readShort();
            byte[] bytes = new byte[len];


            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            DataInputStream pack = new DataInputStream(bais);
            while (pack.available() > 0) {
                dat.add(pack.readUTF());
            }
        } catch (IOException i) {
        }

    }

    public ArrayList<String> getData() {
        return dat;
    }

    public String getServer() {
        return server;
    }

    public String getSubChannel() {
        return subChannel;
    }
}
