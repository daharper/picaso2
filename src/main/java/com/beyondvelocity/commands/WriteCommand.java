package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Text;
import com.beyondvelocity.utils.Input;

/*
 * Writes text onto the canvas.
 */
public class WriteCommand extends Command{

    public WriteCommand() {
        super("W x y hello world", "writes hello world at (X,Y)", 3, true);
    }

    @Override
    protected void run(Input in, Canvas canvas) {
        var x = in.intArg(0);
        var y = in.intArg(1);

        var sb = new StringBuilder();

        for(var i = 2; i < in.argCount(); ++i) {
            sb.append(in.arg(i));
            sb.append(' ');
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        Text.draw(canvas, x, y, sb.toString());
    }
}
