package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.*;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.UserCommand;

/*
 * Demonstrates the application's functionality.
 */
@UserCommand(text = "a", example = "A", description = "runs the author's demo")
public class AuthorCommand extends Command {

    @Override
    protected void run(Input input, Canvas canvas) {
        canvas.create(40, 13);
        Text.draw(canvas, 1, 1, "David Harper");
        Text.draw(canvas, 1, 2, "Java Wizard");
        Text.draw(canvas, 1, 3, "9106 0579");
        Line.draw(canvas, 1, 5, 16, 5, '_');
        Line.draw(canvas, 16, 1, 16, 5, '|');
        Fill.draw(canvas, 13, 1, '.');
        Triangle.draw(canvas, 32, 1, 27, 4, 37, 4, Canvas.PEN);
        Plot.draw(canvas, 29, 5, '|');
        Plot.draw(canvas, 29, 6, '|');
        Plot.draw(canvas, 35, 5, '|');
        Plot.draw(canvas, 35, 6, '|');
        Plot.draw(canvas, 31, 5, 'O');
        Plot.draw(canvas, 33, 5, 'O');
        Plot.draw(canvas, 32, 6, '-');
        Fill.draw(canvas, 32, 2, 'x');
        Line.draw(canvas, 26, 7, 38, 7, Canvas.PEN);
        Line.draw(canvas, 31, 7, 28, 9, Canvas.PEN);
        Line.draw(canvas, 33, 7, 36, 9, Canvas.PEN);
        Line.draw(canvas, 25, 7, 22, 4, '\\');
        Line.draw(canvas, 20, 3, 22, 3, '+');
        Line.draw(canvas, 21, 2, 21, 4, '+');
        Text.draw(canvas, 1, 7, "+ Eligible to work");
        Text.draw(canvas, 1, 8, "+ Available now");
        Text.draw(canvas, 1, 9, "+ Locally based");
        Line.draw(canvas, 1, 11, 40, 11, '_');
        Text.draw(canvas, 3, 12, "email: david@beyondvelocity.com.au");
        Text.draw(canvas, 3, 13, "blog:  https://beyondvelocity.blog");
    }
}
