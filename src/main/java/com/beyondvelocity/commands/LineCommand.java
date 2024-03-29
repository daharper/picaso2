package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Command;
import com.beyondvelocity.core.Input;
import com.beyondvelocity.graphics.Line;

/*
 * Draws a line on the canvas.
 */
public class LineCommand extends Command {

    public LineCommand() {
        super("L x1 y1 x2 y2 c", "draws a line with optional 'c' colour", 4, true);
    }

    @Override
    public void execute(Input in, Canvas canvas) {
        var x1 = in.x1();
        var y1 = in.y1();
        var x2 = in.x2();
        var y2 = in.y2();

        var pen = in.argCount() == 5 ? in.pen(4) : Canvas.PEN;

        Line.draw(canvas, x1, y1, x2, y2, pen);
    }
}
