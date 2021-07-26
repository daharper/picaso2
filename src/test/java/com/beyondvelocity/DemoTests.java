package com.beyondvelocity;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.components.Renderer;
import com.beyondvelocity.graphics.Fill;
import com.beyondvelocity.graphics.Line;
import com.beyondvelocity.graphics.Rectangle;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTests {
    private final Canvas canvas = new Canvas();

    @Test
    void testDisplaysDemo() {
        var expected =
            "oooooooooooooxxxxxoo" +
            "xxxxxxooooooox   xoo" +
            "     xoooooooxxxxxoo" +
            "     xoooooooooooooo";

        // C 20 4
        canvas.create(20 ,4);

        // L 1 2 6 2
        Line.draw(canvas, 1, 2, 6, 2, 'x');

        // L 6 3 6 4
        Line.draw(canvas, 6, 3, 6, 4, 'x');

        // R 14 1 18 3
        Rectangle.draw(canvas, 14, 1, 18, 3, 'x');

        // B 10 3 o
        Fill.draw(canvas, 10, 3, 'o');

        assertEquals(expected, canvas.toString());
    }

    @Test
    void testRendersBorder() {
        var expected =
            "----------------------" + System.lineSeparator() +
            "|oooooooooooooxxxxxoo|" + System.lineSeparator() +
            "|xxxxxxooooooox   xoo|" + System.lineSeparator() +
            "|     xoooooooxxxxxoo|" + System.lineSeparator() +
            "|     xoooooooooooooo|" + System.lineSeparator() +
            "----------------------" + System.lineSeparator();

                // C 20 4
        canvas.create(20 ,4);

        // L 1 2 6 2
        Line.draw(canvas, 1, 2, 6, 2, 'x');

        // L 6 3 6 4
        Line.draw(canvas, 6, 3, 6, 4, 'x');

        // R 14 1 18 3
        Rectangle.draw(canvas, 14, 1, 18, 3, 'x');

        // B 10 3 o
        Fill.draw(canvas, 10, 3, 'o');

        var out = System.out;
        var buf = new ByteArrayOutputStream();

        System.setOut(new PrintStream(buf));

        try {
            var renderer = new Renderer(canvas);
            renderer.drawCanvas();
        } finally {
            System.setOut(out);
        }

        assertEquals(expected, buf.toString());
    }
}
