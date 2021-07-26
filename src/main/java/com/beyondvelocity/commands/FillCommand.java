package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Fill;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.UserCommand;

/*
 * Bucket fills the canvas.
 */
@UserCommand(text="b", example = "B x y c", description = "bucket fills the area at x,y with 'c'", args = 3)
public class FillCommand extends Command{

    @Override
    protected void run(Input input, Canvas canvas) {
        var x = input.intArg(0);
        var y = input.intArg(1);
        var c = input.charArg(2);

        Fill.draw(canvas, x, y, c);
    }
}
