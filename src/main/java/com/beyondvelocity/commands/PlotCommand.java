package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Plot;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.UserCommand;

/*
 * Plots a pixel on the canvas.
 */
@UserCommand(text = "p", example = "P x y c", description = "plots the color 'c' at (X,Y)", args = 3)
public class PlotCommand extends Command {

    @Override
    protected void run(Input input, Canvas canvas) {
        var x = input.intArg(0);
        var y = input.intArg(1);
        var c = input.charArg(2);

        Plot.draw(canvas, x, y, c);
    }
}
