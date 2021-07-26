package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.UserCommand;

/*
 * Creates a new canvas.
 */
@UserCommand(text="c", example="C w h", description="creates a new canvas of width w and height h", args = 2)
public class CanvasCommand extends Command {

    @Override
    protected void run(Input input, Canvas canvas) {
        var width = input.intArg(0);
        var height = input.intArg(1);

        canvas.create(width, height);
    }
}
