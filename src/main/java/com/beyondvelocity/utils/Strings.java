package com.beyondvelocity.utils;

/*
 * String utility methods.
 */
public class Strings {
    /*
     * Determines whether the specified string is null or blank.
     */
    public static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty() || text.isBlank();
    }

    /*
     * Append spaces to the specified string until it is of the desired length.
     */
    public static String padRight(String text, int length) {
        if (text == null) return repeat(' ', length);

        if (text.length() < length) {
            text = text + repeat(' ', length - text.length());
        }

        return text;
    }

    /*
     * Creates a string of the specified character repeated the desired number of times.
     */
    public static String repeat(char ch, int times) {
        assert times > 0;

        var sb = new StringBuilder();

        for(var i = 0; i < times; ++i) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
