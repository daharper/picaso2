package com.beyondvelocity.utils;

import java.util.ArrayList;
import java.util.List;

/*
 * Represents the user input, with utility functions for easy processing.
 */
public class Input {
    // the original text, before processing.
    private final String text;

    // the identified command.
    private final String command;

    // any optionally identified arguments.
    private final List<String> args;

    /*
     * Initializes a new instance with the specified original input text, command, and operands.
     */
    private Input(String text, String command, List<String> args) {
        this.text = text;
        this.command = command;
        this.args = args;
    }

    /*
     * Gets the original text input.
     */
    public String text() {
        return text;
    }

    /*
     * Gets the identified command.
     */
    public String cmd() {
        return command;
    }

    /*
     * Gets the argument at the specified index.
     */
    public String arg(int index) {
        assert index >= 0 && index < args.size() : "argument out of range";
        return args.get(index);
    }

    /*
     * Gets the argument at the specified index as an integer.
     */
    public int intArg(int index) {
        var arg = arg(index);
        return Integer.parseInt(arg);
    }

    /*
     * Gets the argument at the specified index as a character.
     */
    public char charArg(int index) {
        var arg = arg(index);
        return arg.charAt(0);
    }

    /*
     * Gets the number of arguments.
     */
    public int argCount() {
        return args.size();
    }

    /*
     * Creates a new input instance from the specified text.
     */
    public static Input create(String text) {
        assert !(text.isBlank() || text.isEmpty());

        // get all the input tokens
        var tokens = text.split(" ");

        // identify the command
        var command = tokens[0].toLowerCase();

        // identify the operands
        var args = new ArrayList<String>();

        for (var i = 1; i < tokens.length; ++i) {
            if (!Strings.isNullOrBlank(tokens[i])) {
                args.add(tokens[i].trim());
            }
        }

        return new Input(text, command, args);
    }

    /*
     * An empty input instance.
     */
    public static final Input empty = new Input("", "", new ArrayList<>());
}
