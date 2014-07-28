package ChannelCommandAPI.Util.Command;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.plugin.*;

import java.lang.reflect.*;

/**
 * Created by Ben Byers on 7/26/2014.
 */
public class CommandExec extends Command {
    String name;
    String[] aliases;

    public CommandExec(String name, String permission, Method method, String... Alias) {
        super(name, permission, Alias);
        this.name = name;
        this.aliases = Alias;
        CommandExecMap.addCommand(name, method);
        //null is for permissions, null = everyone
    }

    public String getCommand() {
        return name;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        try {
            CommandExecMap.getExec(this.getCommand()).invoke(sender, args);
        } catch (Exception e) {
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String[] getAliases() {
        return this.aliases;
    }
}
