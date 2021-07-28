package com.beyondvelocity;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.graphics.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTests {
    private final Canvas canvas = new Canvas();

    @Test
    void testDrawsHorizontalLine() {
        var expected =
            "xxxx" +
            "    " +
            "    " +
            "    ";

        canvas.create(4, 4);

        Line.draw(canvas, 1, 1, 4, 1, 'x');

        assertEquals(expected, canvas.toString());
    }

    @Test
    void testDrawsVerticalLine() {
        var expected =
            "x   " +
            "x   " +
            "x   " +
            "x   ";

        canvas.create(4, 4);

        Line.draw(canvas, 1, 1, 1, 4, 'x');

        assertEquals(expected, canvas.toString());
    }

    @Test
    void testDrawsDiagonalLine() {
        var expected =
            "x    " +
            " x   " +
            "  x  " +
            "   x " +
            "    x";

        canvas.create(5, 5);

        Line.draw(canvas, 1, 1, 5, 5, 'x');

        assertEquals(expected, canvas.toString());
    }

    @Test
    void testInverseLines() {
        var expected =
            "53336" +
            "51 26" +
            "5 2 6" +
            "52 16" +
            "54446";

        canvas.create(5, 5);

        Line.draw(canvas, 5, 5, 1, 1, '1');
        Line.draw(canvas, 1, 5, 5, 1, '2');
        Line.draw(canvas, 5, 1, 1, 1, '3');
        Line.draw(canvas, 5, 5, 1, 5, '4');
        Line.draw(canvas, 1, 5, 1, 1, '5');
        Line.draw(canvas, 5, 5, 5, 1, '6');

        assertEquals(expected, canvas.toString());
    }
}
