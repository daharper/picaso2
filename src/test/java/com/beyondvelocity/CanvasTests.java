package com.beyondvelocity;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CanvasTests {
    private final Canvas canvas = new Canvas();

    @Test
    void testCreateCanvas() {
        canvas.create(Canvas.MIN_WIDTH, Canvas.MAX_HEIGHT);
        assertEquals(Canvas.MIN_WIDTH, canvas.getWidth());
        assertEquals(Canvas.MAX_HEIGHT, canvas.getHeight());

        canvas.create(Canvas.MAX_WIDTH, Canvas.MIN_HEIGHT);
        assertEquals(Canvas.MAX_WIDTH, canvas.getWidth());
        assertEquals(Canvas.MIN_HEIGHT, canvas.getHeight());
    }

    @Test
    void testCanvasIsEmpty() {
        canvas.create(Canvas.MIN_WIDTH, Canvas.MAX_HEIGHT);

        var expected = String.valueOf(' ').repeat(Canvas.MIN_WIDTH * Canvas.MAX_HEIGHT);
        assertEquals(expected, canvas.toString());
    }

    @Test
    void testPixelValidations() {
        canvas.create(4, 4);

        // x
        assertThrows(ValidationException.class, () -> canvas.setPixel(0, 3, '<'));
        assertThrows(ValidationException.class, () -> canvas.setPixel(5, 3, '<'));

        // y
        assertThrows(ValidationException.class, () -> canvas.setPixel(3, 0, '>'));
        assertThrows(ValidationException.class, () -> canvas.setPixel(3, 5, '>'));

        // pen
        assertThrows(ValidationException.class, () -> canvas.setPixel(2, 2, '☺'));
    }
}
