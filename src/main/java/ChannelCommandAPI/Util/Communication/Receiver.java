package ChannelCommandAPI.Util.Communication;

import ChannelCommandAPI.API.*;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.event.*;

import java.io.*;
import java.util.*;


/**
 * Created by Ben Byers on 7/15/2014.
 * Beta
 */
public class Receiver implements Listener {
    @EventHandler
    public static void PluginMessageEvent(PluginMessageEvent event) {
        String tag = event.getTag();
        byte[] data = event.getData();

        if (ChannelExecMap.ChannelExecMap.containsKey(tag)) {

                /*Perform subchannel decryption as well as data parsing */

            try {


                DataInputStream in = new DataInputStream(new ByteArrayInputStream(data));
                String subchannel = in.readUTF();
                BAConverter clean = new BAConverter(in);
                ChannelExecMap.getExec(tag, subchannel).invoke(clean);
                /**
                 * <p>This calls a registered executor and passes a BAConverter to the executor. This means you NEED to accept
                 * that constructor. IE onKill(BAConverter clean)</p>
                 */


            } catch (Exception x) {
            }
        }
    }
}
