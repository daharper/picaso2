package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Fill;
import com.beyondvelocity.utils.Input;

/*
 * Bucket fills the canvas.
 */
public class FillCommand extends Command{

    public  FillCommand() {
        super("B x y c",  "bucket fills the area at x,y with 'c'", 3, true);
    }

    @Override
    protected void run(Input in, Canvas canvas) {
        var x = in.x1();
        var y = in.y1();
        var c = in.pen(2);

        Fill.draw(canvas, x, y, c);
    }
}
