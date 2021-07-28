package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.utils.Input;

/*
 * Quits the application.
 */
public class QuitCommand extends Command{

    public QuitCommand() {
        super("Q", "quits the program", false);
    }

    @Override
    protected void run(Input in, Canvas canvas) {
        System.out.println("Goodbye, hope you have a nice day :)");
    }
}
