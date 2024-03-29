package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Command;
import com.beyondvelocity.core.Input;
import com.beyondvelocity.core.Renderer;

/*
 * Represents an unknown command.
 */
public class UnknownCommand extends Command {

    private final Renderer renderer;

    public UnknownCommand(Renderer renderer) {
        super();
        this.renderer = renderer;
    }

    @Override
    public void execute(Input in, Canvas canvas) {
        renderer.displayError(
            "I'm sorry, I don't understand your command." + System.lineSeparator() +
             "For more information please enter ?" + System.lineSeparator() +
             "-> " + in.originalText());
    }
}
