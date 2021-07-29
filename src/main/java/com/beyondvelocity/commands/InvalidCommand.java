package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Input;
import com.beyondvelocity.core.Renderer;

/*
 * Represents a failed command.
 */
public class InvalidCommand extends Command {
    private final String error;
    private final Renderer renderer;

    /*
     * Initialize a new instance with the specified error information.
     */
    public InvalidCommand(Renderer renderer, String error) {
        this.error = error;
        this.renderer = renderer;
    }

    @Override
    public void execute(Input in, Canvas canvas) {
        renderer.displayError(
            "There was an error with the command." + System.lineSeparator() +
            "For more information please enter ?" + System.lineSeparator() +
            "-> " + error);
    }
}
