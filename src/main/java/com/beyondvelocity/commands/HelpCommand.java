package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Input;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Provides help functionality.
 */
public class HelpCommand extends Command {
    private final List<String> help;

    public HelpCommand() {
        super("?", "displays a list of commands", false);

        var ctx = context();

        help = ctx.getBeansOfType(Command.class)
                .values()
                .stream()
                .filter(c -> c.example().length() > 0)
                .map(c -> c.example() + String.valueOf(' ').repeat(25 - c.example().length()) + c.description())
                .collect(Collectors.toList());
    }


    @Override
    protected void run(Input in, Canvas canvas) {
        var renderer = renderer();

        renderer.newLine();
        renderer.display("Welcome to Picasso, please use the following commands:");
        renderer.newLine();

        for(var item: help) {
            renderer.display(item);
        }
    }
}
