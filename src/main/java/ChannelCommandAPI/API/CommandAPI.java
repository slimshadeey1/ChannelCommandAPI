package ChannelCommandAPI.API;

import ChannelCommandAPI.API.Interfaces.*;
import ChannelCommandAPI.Util.Command.*;
import net.md_5.bungee.api.plugin.*;

import java.lang.reflect.*;

/**
 * Created by Ben Byers on 7/26/2014.
 */
public class CommandAPI {
    private Plugin plugin = PluginRegister.getPlugin();

    public CommandAPI(Exec exec) {
        for (Method method : exec.getClass().getMethods()) {
            try {
                CommandInt command = method.getAnnotation(CommandInt.class);
                plugin.getProxy().getPluginManager().registerCommand(plugin, new CommandExec(command.command(), command.permission(), method, command.Alias()));
            } catch (Exception e) {
            }
        }
    }
}

