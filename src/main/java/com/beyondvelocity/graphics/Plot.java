package com.beyondvelocity.graphics;

import com.beyondvelocity.components.Canvas;

/*
 * Plot graphics primitive.
 */
public class Plot {
    /*
     * Sets the pixel at the specified coordinate.
     */
    public static void draw(Canvas canvas, int x, int y, char pen) {
        canvas.setPixel(x, y, pen);
    }
}
