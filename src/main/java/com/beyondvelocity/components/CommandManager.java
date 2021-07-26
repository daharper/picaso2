package com.beyondvelocity.components;

import com.beyondvelocity.commands.*;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.Rtti;
import com.beyondvelocity.utils.UserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/*
 * Responsible for managing the execution of user commands.
 */
@Component
public class CommandManager {
    private final Renderer renderer;
    private final Map<String, Class<?>> types = new HashMap<>();
    private final Map<String, UserCommand> annotations = new HashMap<>();

    /*
     * Initializes a new instance of the CommandManager.
     */
    public CommandManager(@Autowired Rtti rtti, @Autowired Renderer renderer) {
        this.renderer = renderer;

        var commands = rtti.getClassesWith(UserCommand.class);

        for(var command: commands) {
            var annotation = command.getAnnotation(UserCommand.class);
            types.put(annotation.text(), command);
            annotations.put(annotation.text(), annotation);
        }
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
        var cmd = input.cmd();

        if (!types.containsKey(cmd)) {
            return unknownCommand(input);
        }

        var cls = types.get(cmd);
        var info = annotations.get(cmd);

        if (input.argCount() < info.args()) {
            return invalidCommand(input, "argument error, expected: " +  info.example());
        }

        try {
            var command = (Command) cls.getConstructor().newInstance();
            command.execute(input);

            if (info.dirty()) {
                renderer.drawCanvas();
            }

            return command;
        } catch (Exception e) {
            return invalidCommand(input, e.getMessage());
        }
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
