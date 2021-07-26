package com.beyondvelocity;

import com.beyondvelocity.components.Canvas;
import com.beyondvelocity.graphics.Fill;
import com.beyondvelocity.graphics.Rectangle;
import com.beyondvelocity.utils.Strings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FillTests {
    private final Canvas canvas = new Canvas();

    @Test
    void testFillsEntireCanvas() {
        var expected = Strings.repeat('o', 4 * 4);

        canvas.create(4, 4);

        Fill.draw(canvas, 1, 1, 'o');

        assertEquals(expected, canvas.toString());
    }

    @Test
    void testRemainsInArea() {
        var expected =
            "       " +
            " xxxxx " +
            " xooox " +
            " xooox " +
            " xooox " +
            " xxxxx " +
            "       ";

        canvas.create(7, 7);

        Rectangle.draw(canvas, 2, 2, 6, 6, 'x');
        Fill.draw(canvas, 3, 3, 'o');

        assertEquals(expected, canvas.toString());
    }

    @Test
    void testRemainsInPen() {
        var expected =
            "       " +
            " ooooo " +
            " o   o " +
            " o   o " +
            " o   o " +
            " ooooo " +
            "       ";

        canvas.create(7, 7);

        Rectangle.draw(canvas, 2, 2, 6, 6, 'x');
        Fill.draw(canvas, 2, 2, 'o');

        assertEquals(expected, canvas.toString());
    }
}
