package com.beyondvelocity.components;

import com.beyondvelocity.utils.Input;
import com.beyondvelocity.utils.Strings;
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
    public InputProcessor(@Autowired Renderer renderer) {
        this.renderer = renderer;
    }

    /*
     * Processes input from the user.
     */
    public Input execute() {
        renderer.newLine();

        var text = "";

        while (Strings.isNullOrBlank(text)) {
            renderer.displayPrompt();
            text = in.nextLine();
        }

        return Input.create(text.trim());
    }
}
