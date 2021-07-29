package com.beyondvelocity;

import com.beyondvelocity.commands.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan
public class ProjectConfig {
    @Bean(name="a")
    public AuthorCommand authorCommand() {
        return new AuthorCommand();
    }

    @Bean(name="c")
    public CanvasCommand canvasCommand() {
        return new CanvasCommand();
    }

    @Bean(name="d")
    public DemoCommand demoCommand() {
        return new DemoCommand();
    }

    @Bean(name="b")
    public FillCommand fillCommand() {
        return new FillCommand();
    }

    @Bean(name="?")
    @Lazy
    public HelpCommand helpCommand() {
        return new HelpCommand();
    }

    @Bean(name="l")
    public LineCommand lineCommand() {
        return new LineCommand();
    }

    @Bean(name="p")
    public PlotCommand plotCommand() {
        return new PlotCommand();
    }

    @Bean(name="q")
    public QuitCommand quitCommand() {
        return new QuitCommand();
    }

    @Bean(name="r")
    public RectangleCommand rectangleCommand() {
        return new RectangleCommand();
    }

    @Bean(name="t")
    public TriangleCommand triangleCommand() {
        return new TriangleCommand();
    }

    @Bean(name="w")
    public WriteCommand writeCommand() {
        return new WriteCommand();
    }
}
