package com.beyondvelocity.graphics;

import com.beyondvelocity.core.Canvas;
import com.beyondvelocity.core.CanvasException;

/*
 * Bucket fill graphics primitive.
 */
public class Fill {
    private final Canvas canvas;
    private final char pen;
    private final char targetPen;

    /*
     * Bucket fills the canvas at the specified coordinates with the pen
     */
    public static void draw(Canvas canvas, int x, int y, char pen) {
        var targetPen = canvas.getPixel(x ,y);

        if (targetPen == pen) {
            throw new CanvasException("target is already filled with: " + pen);
        }

        var fill = new Fill(canvas, x, y, pen, targetPen);
        fill.visit(x, y);
    }

    // initializes a new instance with the specified arguments
    private Fill(Canvas canvas, int x, int y, char pen, char targetPen) {
        this.canvas = canvas;
        this.pen = pen;
        this.targetPen = targetPen;
    }

    // recursively sets the pixel at the specified coordinate
    private void visit(int x, int y) {
        canvas.setPixel(x, y, pen);

        if (isUp(x, y)) visit(x, y-1);
        if (isDown(x, y)) visit(x, y+1);
        if (isLeft(x, y)) visit(x-1, y);
        if (isRight(x, y)) visit(x+1, y);
    }

    // determines if we can fill the pixel above
    private boolean isUp(int x, int y) {
        return y > 1 && canvas.getPixel(x, y-1) == targetPen;
    }

    // determines if we can fill the pixel below
    private boolean isDown(int x, int y) {
        return y < canvas.getHeight() && canvas.getPixel(x, y+1) == targetPen;
    }

    // determines if we can fill the pixel to the left
    private boolean isLeft(int x, int y) {
        return x > 1 && canvas.getPixel(x-1, y) == targetPen;
    }

    // determines if the can fill the pixel to the right
    private boolean isRight(int x, int y) {
        return x < canvas.getWidth() && canvas.getPixel(x+1, y) == targetPen;
    }
}
