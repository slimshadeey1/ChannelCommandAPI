package ChannelCommandAPI;

import ChannelCommandAPI.API.*;
import ChannelCommandAPI.API.Interfaces.*;
import ChannelCommandAPI.Objects.*;
import ChannelCommandAPI.Util.Communication.*;
import net.md_5.bungee.api.*;

/**
 * Created by Ben Byers on 7/27/2014.
 */
public class Test implements Exec {
    public void onEnable() {
        new ChannelAPI(this);
        /**
         Say that channels will be executed in this class, this in turn looks for methods
         that have the channelInt annotation with the the channel and subchannel defined,
         in turn this will be registered.
         */
        new CommandAPI(this);
        /**
         Say that commands will be executed in this class, this in turn looks for methods
         that have the commandInt annotation with the the command defined,
         in turn this will be registered.
         */
    }

    //Example of a channel exec defined
    @ChannelInt(channel = "MyChannel", subchannel = "mySub")
    public void onMySub(BAin clean) { //Always have BAin in the arguments, your method is invoked with that! Just like a event in bukkit
        clean.getServer();
        clean.getData();
        clean.getSubChannel();
        //Stuff to run
    }

    //Example of a command exec combined
    @CommandInt(command = "Test")
    public void onMyCommand(CommandSender sender, String[] args) {//Always like this or command feature will not work!
        //Stuff to run
    }
}
