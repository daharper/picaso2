package com.beyondvelocity;

import com.beyondvelocity.commands.HelpCommand;
import com.beyondvelocity.commands.QuitCommand;
import com.beyondvelocity.core.CommandManager;
import com.beyondvelocity.core.InputProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var manager = context.getBean(CommandManager.class);
        var processor = context.getBean(InputProcessor.class);
        var command = manager.execute(context.getBean(HelpCommand.class));

        while (!(command instanceof QuitCommand)) {
            var input = processor.execute();
            command = manager.execute(input);
        }
    }
}
