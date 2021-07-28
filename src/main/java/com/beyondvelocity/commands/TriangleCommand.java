package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Triangle;
import com.beyondvelocity.utils.Input;

/*
 * Draws a triangle on the canvas.
 */
public class TriangleCommand extends Command{

    public TriangleCommand() {
        super("T x1 y1 x2 y2 x3 y3 c", "creates a triangle with optional color 'c'", 6, true);
    }

    @Override
    protected void run(Input in, Canvas canvas) {
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
