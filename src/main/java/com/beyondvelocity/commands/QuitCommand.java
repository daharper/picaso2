package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.UserCommand;

/*
 * Quits the application.
 */
@UserCommand(text = "q", example = "Q", description = "quits the program", dirty = false)
public class QuitCommand extends Command{

    @Override
    protected void run(Input input, Canvas canvas) {
        System.out.println("Goodbye, hope you have a nice day :)");
    }
}
