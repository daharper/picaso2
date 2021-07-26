package com.beyondvelocity.commands;

import com.beyondvelocity.utils.Input;
import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.components.Renderer;
import com.beyondvelocity.utils.ContextProvider;
import com.beyondvelocity.utils.Rtti;
import org.springframework.context.ApplicationContext;

/*
 * Command base, providing essential functionality and abstraction for all commands.
 */
public abstract class Command {
    /*
     * Executes the command
     */
    public void execute(Input input) {
        var canvas = context().getBean(Canvas.class);
        run(input, canvas);
    }

    // abstract run method called by execute
    protected abstract void run(Input input, Canvas canvas);

    // gets the application context
    protected ApplicationContext context() {
        return ContextProvider.getContext();
    }

    // gets the rtti instance for reflection
    protected Rtti rtti() {
        return context().getBean(Rtti.class);
    }

    // gets the renderer for displaying information
    protected Renderer renderer() {
        return context().getBean(Renderer.class);
    }
}
