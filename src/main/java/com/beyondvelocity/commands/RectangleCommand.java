package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Rectangle;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.UserCommand;

/*
 * Draws a rectangle on the canvas.
 */
@UserCommand(text = "r", example = "R x1 y1 x2 y2 c", description = "draws a rectangle of (x1,y1),(x2,y2) with optional 'c' colour", args = 4)
public class RectangleCommand extends Command {

    @Override
    protected void run(Input input, Canvas canvas) {
        var x1 = input.intArg(0);
        var y1 = input.intArg(1);
        var x2 = input.intArg(2);
        var y2 = input.intArg(3);
        var c = input.argCount() == 5 ? input.charArg(4) : Canvas.PEN;

        Rectangle.draw(canvas, x1, y1, x2, y2, c);
    }
}
