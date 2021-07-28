package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.utils.Input;

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
