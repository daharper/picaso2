package com.beyondvelocity.core;

import com.beyondvelocity.commands.InvalidCommand;
import com.beyondvelocity.commands.UnknownCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/*
 * Responsible for managing the execution of user commands.
 */
@Component
public class CommandManager {
    private final Renderer renderer;
    private final ApplicationContext context;
    private final Canvas canvas;

    /*
     * Initializes a new instance of the CommandManager.
     */
    public CommandManager(@Autowired ApplicationContext context, @Autowired Canvas canvas, @Autowired Renderer renderer) {
        this.renderer = renderer;
        this.context = context;
        this.canvas = canvas;
    }

    /*
     * Executes a simple command with no input, for example the HelpCommand.
     */
    public Command execute(Command command) {
        command.execute(Input.empty, canvas);
        return command;
    }

    /*
     * Executes the command represented by the specified input.
     */
    public Command execute(Input input) {
        Command cmd;

        try {
            //cmd = (Command)ContextProvider.getContext().getBean(input.cmd());
            cmd = (Command)context.getBean(input.cmd());
        } catch (Exception e){
            return unknownCommand(input);
        }

        if (input.argCount() < cmd.minArgs()) {
            return invalidCommand(input, "argument error, expected: " +  cmd.example());
        }

        try {
            cmd.execute(input, canvas);

            if (cmd.dirty()) {
                renderer.drawCanvas();
            }
        } catch (Exception e) {
            cmd = invalidCommand(input, e.getMessage());
        }

        return cmd;
    }

    /*
     * executes and returns an invalid command.
     */
    private Command invalidCommand(Input input, String error) {
        var cmd = new InvalidCommand(renderer, error);
        cmd.execute(input, canvas);
        return cmd;
    }

    /*
     * executes and returns an unknown command.
     */
    private Command unknownCommand(Input input) {
        var cmd = new UnknownCommand(renderer);
        cmd.execute(input, canvas);
        return cmd;
    }
}
