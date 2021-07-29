package com.beyondvelocity.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/*
 * Responsible for processing user input.
 */
@Component
public class InputProcessor {
    private final Renderer renderer;
    private final Scanner in = new Scanner(System.in);

    /*
     * Initializes a new instance with the specified renderer.
     */
    @Autowired
    public InputProcessor(Renderer renderer) {
        this.renderer = renderer;
    }

    /*
     * Processes input from the user.
     */
    public Input execute() {
        renderer.newLine();

        var text = "";

        while (text.isEmpty()) {
            renderer.displayPrompt();
            text = in.nextLine().trim();
        }

        return Input.create(text.trim());
    }
}
