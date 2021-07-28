package com.beyondvelocity.commands;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Provides help functionality.
 */
public class HelpCommand extends Command {
    private List<String> help;

    public HelpCommand() {
        super("?", "displays a list of commands", false);
    }

    private void generateHelp() {
        var ctx = context();

        help = ctx.getBeansOfType(Command.class)
                .values()
                .stream()
                .filter(c -> !Strings.isNullOrBlank(c.example()))
                .map(c -> Strings.padRight(c.example(), 25) + c.description())
                .collect(Collectors.toList());
    }


    @Override
    protected void run(Input in, Canvas canvas) {
        if (help == null) {
            generateHelp();
        }

        var renderer = renderer();

        renderer.newLine();
        renderer.display("Welcome to Picasso, please use the following commands:");
        renderer.newLine();

        for(var item: help) {
            renderer.display(item);
        }
    }
}
