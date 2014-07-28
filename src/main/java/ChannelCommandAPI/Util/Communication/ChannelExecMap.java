package ChannelCommandAPI.Util.Communication;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/26/2014.
 */
public class ChannelExecMap {
    protected static HashMap<String, TreeMap<String, Method>> ChannelExecMap = new HashMap<String, TreeMap<String, Method>>();

    public static void addChannel(String Channel, String subChannel, Method executor) {
        if (ChannelExecMap.containsKey(Channel.toLowerCase())) {
            TreeMap<String, Method> subExec = ChannelExecMap.remove(Channel.toLowerCase());
            subExec.put(subChannel.toLowerCase(), executor);
            ChannelExecMap.put(Channel.toLowerCase(), subExec);
        } else {
            TreeMap<String, Method> subExec = new TreeMap<String, Method>();
            subExec.put(subChannel.toLowerCase(), executor);
            ChannelExecMap.put(Channel.toLowerCase(), subExec);
        }
    }

    public static Method getExec(String Channel, String SubChannel) {
        TreeMap<String, Method> SubExec = ChannelExecMap.get(Channel.toLowerCase());
        return SubExec.get(SubChannel.toLowerCase());
    }
}
