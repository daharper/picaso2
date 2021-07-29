package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Command;
import com.beyondvelocity.core.Input;
import com.beyondvelocity.graphics.Triangle;

/*
 * Draws a triangle on the canvas.
 */
public class TriangleCommand extends Command {

    public TriangleCommand() {
        super("T x1 y1 x2 y2 x3 y3 c", "creates a triangle with optional color 'c'", 6, true);
    }

    @Override
    public void execute(Input in, Canvas canvas) {
        var x1 = in.x1();
        var y1 = in.y1();
        var x2 = in.x2();
        var y2 = in.y2();
        var x3 = in.x3();
        var y3 = in.y3();

        var pen = in.argCount() == 7 ? in.pen(6) : Canvas.PEN;

        Triangle.draw(canvas, x1, y1, x2, y2, x3, y3, pen);
    }
}
