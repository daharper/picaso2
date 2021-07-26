package com.beyondvelocity.utils;

import java.lang.annotation.*;

/*
 * Declares commands information to the application.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UserCommand {
    // the actual command text, for example c for canvas
    String text() default "";

    // an example expected arguments
    String example() default "";

    // a description of what the command does
    String description() default "";

    // the number of mandatory arguments
    int args() default 0;

    // does this command update the canvas?
    boolean dirty() default true;
}
