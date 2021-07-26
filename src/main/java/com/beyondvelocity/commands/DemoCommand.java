package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Fill;
import com.beyondvelocity.graphics.Line;
import com.beyondvelocity.graphics.Rectangle;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.UserCommand;

/*
 * Demonstrates the application functionality as per requirements.
 */
@UserCommand(text = "d", example = "D", description = "runs the requirement's demo")
public class DemoCommand extends Command{

    @Override
    protected void run(Input input, Canvas canvas) {
        canvas.create(20, 4);
        Line.draw(canvas, 1, 2, 6, 2, Canvas.PEN);
        Line.draw(canvas, 6, 3, 6, 4, Canvas.PEN);
        Rectangle.draw(canvas, 14, 1, 18, 3, Canvas.PEN);
        Fill.draw(canvas, 10 ,3, 'o');
    }
}
