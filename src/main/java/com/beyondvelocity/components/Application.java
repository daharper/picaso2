package com.beyondvelocity.components;

import com.beyondvelocity.commands.HelpCommand;
import com.beyondvelocity.commands.QuitCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * The Picasso Application.
 */
@Component
public class Application {
    private final CommandManager manager;
    private final InputProcessor processor;

    /*
     * Initializes a new instance of the application.
     */
    public Application(@Autowired CommandManager manager, @Autowired InputProcessor processor) {
        this.manager = manager;
        this.processor = processor;
    }

    /*
     * The main execution loop, exits when the user enters quit.
     */
    public void execute() {
        var command = manager.execute(new HelpCommand());

        do {
            var input = processor.execute();
            command = manager.execute(input);
        } while (!(command instanceof QuitCommand));
    }
}

