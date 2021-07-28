package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Fill;
import com.beyondvelocity.graphics.Line;
import com.beyondvelocity.graphics.Rectangle;
import com.beyondvelocity.utils.Input;

/*
 * Demonstrates the application functionality as per requirements.
 */
public class DemoCommand extends Command{

    public DemoCommand() {
        super("D", "runs the requirement's demo", true);
    }

    @Override
    protected void run(Input in, Canvas canvas) {
        canvas.create(20, 4);
        Line.draw(canvas, 1, 2, 6, 2, Canvas.PEN);
        Line.draw(canvas, 6, 3, 6, 4, Canvas.PEN);
        Rectangle.draw(canvas, 14, 1, 18, 3, Canvas.PEN);
        Fill.draw(canvas, 10 ,3, 'o');
    }
}
