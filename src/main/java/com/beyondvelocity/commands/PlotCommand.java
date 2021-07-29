package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Command;
import com.beyondvelocity.core.Input;
import com.beyondvelocity.graphics.Plot;

/*
 * Plots a pixel on the canvas.
 */
public class PlotCommand extends Command {

    public PlotCommand() {
        super("P x y c", "plots the color 'c' at (x,y)", 3, true);
    }

    @Override
    public void execute(Input in, Canvas canvas) {
        var x = in.x1();
        var y = in.y1();
        var pen = in.pen(2);

        Plot.draw(canvas, x, y, pen);
    }
}
