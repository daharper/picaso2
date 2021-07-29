package com.beyondvelocity.core;

import java.util.ArrayList;
import java.util.List;

/*
 * Represents the user input, with utility functions for easy processing.
 */
public class Input {
    // the original text, before processing.
    private final String originalText;

    // the identified command.
    private final String command;

    // any optionally identified arguments.
    private final List<String> args;

    /*
     * Initializes a new instance with the specified original input text, command, and operands.
     */
    private Input(String text, String command, List<String> args) {
        this.originalText = text;
        this.command = command;
        this.args = args;
    }

    /*
     * Gets the original text input.
     */
    public String originalText() {
        return originalText;
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
     * Gets the x1 value - conventional utility function, returns argument 0.
     */
    public int x1() {
        return intArg(0);
    }

    /*
     * Gets the y1 value - conventional utility function, returns argument 1.
     */
    public int y1() {
        return intArg(1);
    }

    /*
     * Gets the x2 value - conventional utility function, returns argument 2.
     */
    public int x2() {
        return intArg(2);
    }

    /*
     * Gets the y2 value - conventional utility function, returns argument 3.
     */
    public int y2() {
        return intArg(3);
    }

    /*
     * Gets the x3 value - conventional utility function, return argument 4.
     */
    public int x3() {
        return intArg(4);
    }

    /*
     * Gets the y3 value - conventional utility function, return argument 5.
     */
    public int y3() {
        return intArg(5);
    }

    /*
     * Gets the pen argument at the specified index.
     */
    public char pen(int index) {
        var arg = arg(index);
        return arg.charAt(0);
    }

    /*
     * Gets a string concatenation of all arguments from the specified index.
     */
    public String text(int index) {
        var sb = new StringBuilder();

        for(var i = 2; i < argCount(); ++i) {
            sb.append(arg(i));
            sb.append(' ');
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
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
            var token = tokens[i];
            if (!token.isBlank()){
                args.add(token.trim());
            }
        }

        return new Input(text, command, args);
    }

    /*
     * An empty input instance.
     */
    public static final Input empty = new Input("", "", new ArrayList<>());
}
