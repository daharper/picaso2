package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Text;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.UserCommand;

/*
 * Writes text onto the canvas.
 */
@UserCommand(text = "w", example = "W x y hello world", description = "writes hello world at (X,Y)", args = 3)
public class WriteCommand extends Command{

    @Override
    protected void run(Input input, Canvas canvas) {
        var x = input.intArg(0);
        var y = input.intArg(1);

        var sb = new StringBuilder();

        for(var i = 2; i < input.argCount(); ++i) {
            sb.append(input.arg(i));
            sb.append(' ');
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        Text.draw(canvas, x, y, sb.toString());
    }
}
