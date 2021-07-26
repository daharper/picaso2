package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Triangle;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.UserCommand;

/*
 * Draws a triangle on the canvas.
 */
@UserCommand(text = "t", example = "T x1 y1 x2 y2 x3 y3 c", description = "creates a triangle for (x1,y1),(x2, y2),(x3,y3) with optional color 'c'", args = 6)
public class TriangleCommand extends Command{

    @Override
    protected void run(Input input, Canvas canvas) {
        var x1 = input.intArg(0);
        var y1 = input.intArg(1);
        var x2 = input.intArg(2);
        var y2 = input.intArg(3);
        var x3 = input.intArg(4);
        var y3 = input.intArg(5);
        var c = input.argCount() == 7 ? input.charArg(6) : Canvas.PEN;

        Triangle.draw(canvas, x1, y1, x2, y2, x3, y3, c);
    }
}
