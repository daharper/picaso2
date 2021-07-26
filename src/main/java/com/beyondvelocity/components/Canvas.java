package com.beyondvelocity.components;

import com.beyondvelocity.utils.ValidationException;
import org.springframework.stereotype.Component;

/*
 * Represents the canvas the user is drawing upon.
 */
@Component
public class Canvas {
    // a pixel can only be of these characters
    private static final String VALID_PENS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()_+-={}[]|;:'<>.,?/ \\\"";

    // dimensions
    private int width;
    private int height;

    // using flat memory for internal storage
    private char[] pixels;

    // the default character for drawing operations
    public static final char PEN = 'x';

    // size constraints
    public static final int MIN_WIDTH = 4;
    public static final int MAX_WIDTH = 40;
    public static final int MIN_HEIGHT = 4;
    public static final int MAX_HEIGHT = 40;

    /*
     * Initializes a new instance of the canvas.
     */
    public Canvas() {
        create(20, 4);
    }

    /*
     * Creates a canvas according to the specified width and height.
     */
    public void create(int width, int height) {
        if (width < MIN_WIDTH || width > MAX_WIDTH) {
            throw new ValidationException(String.format("width must be %d..%d", MIN_WIDTH, MAX_WIDTH));
        }

        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new ValidationException(String.format("height must be %d..%d", MIN_HEIGHT, MAX_HEIGHT));
        }

        this.width = width;
        this.height = height;
        this.pixels = new char[height * width];

        clear();
    }

    /*
     * Clears the canvas.
     */
    public void clear() {
        for(int y = 1; y <= height; ++y) {
            for(int x = 1; x <= width; ++x) {
                setPixel(x, y, ' ');
            }
        }
    }

    @Override
    public String toString() {
        return new String(pixels);
    }

    /*
     * Gets the width of the canvas.
     */
    public int getWidth() {
        return width;
    }

    /*
     * Gets the height of the canvas.
     */
    public int getHeight() {
        return height;
    }

    /*
     * Gets the pixel at the specified x and y coordinate.
     */
    public char getPixel(int x, int y) {
        var index = getIndex(x, y);
        return pixels[index];
    }

    /*
     * Sets the pixel as per the specified x and y coordinate, and pen.
     */
    public void setPixel(int x, int y, char pen) {
        validate(pen);

        var index = getIndex(x, y);
        pixels[index] = pen;
    }

    // verifies that the specified pen is valid
    public void validate(char pen) {
        if (VALID_PENS.indexOf(pen) < 0) {
            throw new ValidationException("invalid pen, cannot write to canvas.");
        }
    }

    /*
     * validates the specified coordinates are valid
     */
    public void validate(int x, int y) {
        if (x < 1 || x > width) {
            throw new ValidationException("an x coordinate is not on the canvas");
        }

        if (y < 1 || y > height) {
            throw new ValidationException("a y coordinate is not on the canvas");
        }
    }

    // adapts the user's coordinates to our internal structure
    private int getIndex(int x, int y) {
        validate(x, y);
        return (y - 1) * width + x - 1;
    }
}
