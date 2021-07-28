package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Input;

/*
 * Creates a new canvas.
 */
public class CanvasCommand extends Command {

    public CanvasCommand() {
        super("C w h", "creates a new canvas of width w and height h", 2, true);
    }

    @Override
    protected void run(Input in, Canvas canvas) {
        var width = in.intArg(0);
        var height = in.intArg(1);

        canvas.create(width, height);
    }
}
