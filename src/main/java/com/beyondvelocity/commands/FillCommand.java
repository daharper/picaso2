package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Command;
import com.beyondvelocity.core.Input;
import com.beyondvelocity.graphics.Fill;

/*
 * Bucket fills the canvas.
 */
public class FillCommand extends Command {

    public  FillCommand() {
        super("B x y c",  "bucket fills the area at x,y with 'c'", 3, true);
    }

    @Override
    public void execute(Input in, Canvas canvas) {
        var x = in.x1();
        var y = in.y1();
        var pen = in.pen(2);

        Fill.draw(canvas, x, y, pen);
    }
}
