package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.Strings;
import com.beyondvelocity.utils.UserCommand;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Provides help functionality.
 */
@UserCommand(text = "?", example = "?", description = "displays a list of commands", dirty = false)
public class HelpCommand extends Command {
    private static List<String> help;

    /*
     * Initializes a new instance of the help command, discovers help information.
     */
    public HelpCommand() {
        if (help != null) return;

        help = rtti().getClassesWith(UserCommand.class)
              .stream()
              .map(c -> {
                  var a = c.getAnnotation(UserCommand.class);
                  return Strings.padRight(a.example(), 25) + a.description(); })
              .sorted()
              .collect(Collectors.toList());
    }

    @Override
    protected void run(Input input, Canvas canvas) {
        var renderer = renderer();

        renderer.newLine();
        renderer.display("Welcome to Picasso, please use the following commands:");
        renderer.newLine();

        for(var item: help) {
            renderer.display(item);
        }
    }
}
