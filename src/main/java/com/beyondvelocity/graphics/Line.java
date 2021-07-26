package com.beyondvelocity.graphics;

import com.beyondvelocity.components.Canvas;

/*
 * Line graphics primitive.
 */
public class Line {
    /*
     * Draws a line on the canvas as per the specified arguments.
     */
    public static void draw(Canvas canvas, int x1, int y1, int x2, int y2, char pen) {
        canvas.validate(x1, y1);
        canvas.validate(x2, y2);

        if (x1 == x2) {
            drawVerticalLine(canvas, x1, y1, y2, pen);
        } else if (y1 == y2) {
            drawHorizontalLine(canvas, x1, x2, y1, pen);
        } else {
            drawDiagonalLine(canvas, x1, y1, x2, y2, pen);
        }
    }

    // draws a vertical line.
    private static void drawVerticalLine(Canvas canvas, int x, int y1, int y2, char pen) {
        // we want to draw from y1..y2, swap variables if given y2..y1
        if (y2 < y1) {
            y1 = y1 ^ y2 ^ (y2 = y1);
        }

        for (var y = y1; y <= y2; ++y) {
            canvas.setPixel(x, y, pen);
        }
    }

    // draws a horizontal line.
    private static void drawHorizontalLine(Canvas canvas, int x1, int x2, int y, char pen) {
        // we want to draw from x1..x2, swap variables if given x2..x1
        if (x2 < x1) {
            x1 = x1 ^ x2 ^ (x2 = x1);
        }

        for(var x = x1; x <= x2; ++x) {
            canvas.setPixel(x, y, pen);
        }
    }

    // draws a diagonal line.
    private static void drawDiagonalLine(Canvas canvas, int x1, int y1, int x2, int y2, char pen) {
        // we want to draw from (x1,y1)..(x2, y2), swap if given (x2, y2)..(x1, y1)
        if (y1 > y2) {
            y1 = y1 ^ y2 ^ (y2 = y1);
            x1 = x1 ^ x2 ^ (x2 = x1);
        }

        var yPixels = y2 - y1 + 1;
        var xPixels = Math.abs(x2 - x1) + 1;
        var xOffset = x2 > x1 ? 1 : -1;
        var x = x1;
        var y = y1;

        // if the line is more vertical, we'll draw by enumerating all the y points.
        if (yPixels > xPixels) {
            var step = yPixels / xPixels;

            for(var i = 1; i <= yPixels; ++i) {
                canvas.setPixel(x, y++, pen);

                if (i % step == 0) {
                    if ((xOffset == -1 && x > x2) || (xOffset == 1 && x < x2)) {
                        x += xOffset;
                    }
                }
            }
            return;
        }

        // line is more horizontal, we'll draw by enumerating all the x points.
        var step = xPixels / yPixels;

        for (var i = 1; i <= xPixels; ++i) {
            canvas.setPixel(x, y, pen);

            x += xOffset;

            if (i % step == 0 && y < y2) {
                ++y;
            }
        }
    }
}


