package com.beyondvelocity.components;

import com.beyondvelocity.utils.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.System.*;

/*
 * Responsible for rendering output to the console.
 */
@Component
public class Renderer {
    private final Canvas canvas;

    /*
     * Initializes a new instance of the renderer.
     */
    public Renderer(@Autowired Canvas canvas) {
        this.canvas = canvas;
    }

    /*
     * Display the user input prompt.
     */
    public void displayPrompt() {
        out.print("> ");
    }

    /*
     * Displays the specified text.
     */
    public void display(String text) {
        out.println(text);
    }

    /*
     * Display an empty line.
     */
    public void newLine() {
        out.println();
    }

    /*
     * Display an error message.
     */
    public void displayError(String error) {
        out.println(error);
    }

    /*
     * Draw the canvas to the console.
     */
    public void drawCanvas() {
        var hr = Strings.repeat('-', canvas.getWidth() + 2);

        // top border
        out.println(hr);

        for (var y = 1; y <= canvas.getHeight(); y++) {
            // left border
            out.print('|');

            // canvas
            for (var x = 1; x <= canvas.getWidth(); x++) {
                var pixel = canvas.getPixel(x, y);
                out.print(pixel);
            }

            // right border
            out.println('|');
        }

        // bottom border
        out.println(hr);
    }
}
