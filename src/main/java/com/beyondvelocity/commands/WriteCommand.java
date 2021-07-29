package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Command;
import com.beyondvelocity.core.Input;
import com.beyondvelocity.graphics.Text;

/*
 * Writes text onto the canvas.
 */
public class WriteCommand extends Command {

    public WriteCommand() {
        super("W x y hello world", "writes hello world at (X,Y)", 3, true);
    }

    @Override
    public void execute(Input in, Canvas canvas) {
        var x = in.intArg(0);
        var y = in.intArg(1);
        var text = in.text(2);

        Text.draw(canvas, x, y, text);
    }
}
