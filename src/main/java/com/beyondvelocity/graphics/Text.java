package com.beyondvelocity.graphics;

import com.beyondvelocity.components.Canvas;

/*
 * Text graphics primitive.
 */
public class Text {
    /*
     * Draws the text at the specified coordinates.
     */
    public static void draw(Canvas canvas, int x, int y, String text) {
        for (int i = 0; i < text.length(); i++, x++) {
            if (x > canvas.getWidth()) break;
            canvas.setPixel(x, y, text.charAt(i));
        }
    }
}
