package com.beyondvelocity.graphics;

import com.beyondvelocity.components.Canvas;

/*
 * Rectangle graphics primitive.
 */
public class Rectangle {
    /*
     * Draws the rectangle on the canvas.
     */
    public static void draw(Canvas canvas, int x1, int y1, int x2, int y2, char pen) {
        Line.draw(canvas, x1, y1, x2, y1, pen); // top
        Line.draw(canvas, x1, y2, x2, y2, pen); // bottom
        Line.draw(canvas, x1, y1, x1, y2, pen); // left
        Line.draw(canvas, x2, y1, x2, y2, pen); // right
    }
}
