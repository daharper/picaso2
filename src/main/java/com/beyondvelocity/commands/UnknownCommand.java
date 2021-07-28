package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Input;

/*
 * Represents an unknown command.
 */
public class UnknownCommand extends Command {

    @Override
    protected void run(Input in, Canvas canvas) {
        renderer().displayError(
            "I'm sorry, I don't understand your command." + System.lineSeparator() +
             "For more information please enter ?" + System.lineSeparator() +
             "-> " + in.text());
    }
}
