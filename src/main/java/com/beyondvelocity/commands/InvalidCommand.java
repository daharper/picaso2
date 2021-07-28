package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.utils.Input;

/*
 * Represents a failed command.
 */
public class InvalidCommand extends Command {
    private final String error;

    /*
     * Initialize a new instance with the specified error information.
     */
    public InvalidCommand(String error) {
        this.error = error;
    }

    @Override
    protected void run(Input in, Canvas canvas) {
        renderer().displayError(
            "There was an error with the command." + System.lineSeparator() +
            "For more information please enter ?" + System.lineSeparator() +
            "-> " + error);
    }
}
