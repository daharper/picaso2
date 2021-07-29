package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Command;
import com.beyondvelocity.core.Input;
import com.beyondvelocity.graphics.Fill;
import com.beyondvelocity.graphics.Line;
import com.beyondvelocity.graphics.Rectangle;

/*
 * Demonstrates the application functionality as per requirements.
 */
public class DemoCommand extends Command {

    public DemoCommand() {
        super("D", "runs the requirement's demo", true);
    }

    @Override
    public void execute(Input in, Canvas canvas) {
        canvas.create(20, 4);
        Line.draw(canvas, 1, 2, 6, 2, Canvas.PEN);
        Line.draw(canvas, 6, 3, 6, 4, Canvas.PEN);
        Rectangle.draw(canvas, 14, 1, 18, 3, Canvas.PEN);
        Fill.draw(canvas, 10 ,3, 'o');
    }
}
