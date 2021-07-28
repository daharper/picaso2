package com.beyondvelocity.graphics;

import com.beyondvelocity.core.Canvas;

/*
 * Triangle graphics primitive.
 */
public class Triangle {
    /*
     * Draws a triangle on the canvas according to the specified arguments.
     */
    public static void draw(Canvas canvas, int x1, int y1, int x2, int y2, int x3, int y3, char pen) {
        canvas.validate(x3, y3);

        Line.draw(canvas, x1, y1, x2, y2, pen);
        Line.draw(canvas, x2, y2, x3, y3, pen);
        Line.draw(canvas, x1, y1, x3, y3, pen);
    }
}
