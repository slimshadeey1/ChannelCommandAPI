package ChannelCommandAPI.API.Interfaces;

import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * Created by Ben Byers on 7/26/2014.
 */
@Retention(RetentionPolicy.RUNTIME)

public @interface CommandInt {
    String command() default "";

    String permission() default "";

    String[] subCommands() default "";

    String[] Alias() default "";
}
