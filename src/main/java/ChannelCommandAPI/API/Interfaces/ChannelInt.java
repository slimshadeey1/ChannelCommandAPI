package ChannelCommandAPI.API.Interfaces;

import java.lang.annotation.*;

/**
 * Created by Ben Byers on 7/26/2014.
 */
@Retention(RetentionPolicy.RUNTIME)

public @interface ChannelInt {
    String channel() default "";

    String subchannel() default "";
}
