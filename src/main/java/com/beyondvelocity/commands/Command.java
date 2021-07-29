package com.beyondvelocity.commands;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.Input;

/*
 * Command base, providing essential functionality and abstraction for all commands.
 */
public abstract class Command {
    private final String example;
    private final String description;
    private final int minArgs;
    private final boolean dirty;

    protected Command(String example, String description, int minArgs, boolean dirty) {
        this.example = example;
        this.description = description;
        this.minArgs = minArgs;
        this.dirty = dirty;
    }

    protected Command(String example, String description, boolean dirty) {
        this(example, description, 0, dirty);
    }

    protected Command() {
        this("", "", 0, false);
    }

    /*
     * Gets an example of the command and required arguments.
     */
    public String example() {
        return example;
    }

    /*
     * Gets a description of the command.
     */
    public String description() {
        return description;
    }

    /*
     * Gets the minimum number of required arguments.
     */
    public int minArgs() {
        return minArgs;
    }

    /*
     * Indicates whether this command updated the canvas.
     */
    public boolean dirty() {
        return dirty;
    }

    // Executes the command.
    public abstract void execute(Input in, Canvas canvas);
}