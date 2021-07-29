package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Input;
import com.beyondvelocity.core.Renderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Provides help functionality.
 */
public class HelpCommand extends Command {
    private List<String> help;

    @Autowired
    private Renderer renderer;

    @Autowired
    private ApplicationContext context;

    public HelpCommand() {
        super("?", "displays a list of commands", false);
    }

    private void generateHelp() {
        help = context.getBeansOfType(Command.class)
                .values()
                .stream()
                .filter(c -> c.example().length() > 0)
                .map(c -> c.example() + String.valueOf(' ').repeat(25 - c.example().length()) + c.description())
                .collect(Collectors.toList());
    }


    @Override
    public void execute(Input in, Canvas canvas) {
        if (help == null) {
            generateHelp();
        }

        renderer.newLine();
        renderer.display("Welcome to Picasso, please use the following commands:");
        renderer.newLine();

        for(var item: help) {
            renderer.display(item);
        }
    }
}
