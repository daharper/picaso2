package com.beyondvelocity.components;

import com.beyondvelocity.commands.*;
import com.beyondvelocity.utils.ContextProvider;
import com.beyondvelocity.utils.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Responsible for managing the execution of user commands.
 */
@Component
public class CommandManager {
    private final Renderer renderer;

    /*
     * Initializes a new instance of the CommandManager.
     */
    public CommandManager(@Autowired Renderer renderer) {
        this.renderer = renderer;
    }

    /*
     * Executes a simple command with no input, for example the HelpCommand.
     */
    public Command execute(Command command) {
        command.execute(Input.empty);
        return command;
    }

    /*
     * Executes the command represented by the specified input.
     */
    public Command execute(Input input) {
        Command cmd;

        try {
            cmd = (Command)ContextProvider.getContext().getBean(input.cmd());
        } catch (Exception e){
            return unknownCommand(input);
        }

        if (input.argCount() < cmd.minArgs()) {
            return invalidCommand(input, "argument error, expected: " +  cmd.example());
        }

        try {
            cmd.execute(input);

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
    private static Command invalidCommand(Input input, String error) {
        var cmd = new InvalidCommand(error);
        cmd.execute(input);
        return cmd;
    }

    /*
     * executes and returns an unknown command.
     */
    private static Command unknownCommand(Input input) {
        var cmd = new UnknownCommand();
        cmd.execute(input);
        return cmd;
    }
}
