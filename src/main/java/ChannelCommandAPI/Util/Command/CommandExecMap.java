package ChannelCommandAPI.Util.Command;

import ChannelCommandAPI.API.*;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/26/2014.
 */
public class CommandExecMap {
    protected static HashMap<String, Method> CommandExecMap = new HashMap<String, Method>();
    //protected static HashMap<String,TreeMap<String,Method>> SubCommandExecMap = new HashMap<String,TreeMap<String, Method>>();

    public static void addCommand(String command, Method executor) {
        CommandExecMap.put(command.toLowerCase(), executor);

    }

    public static Method getExec(String command) {
        return CommandExecMap.get(command.toLowerCase());
    }
}
