package com.noturaun.shorty.util;

public class ConversionUtil {

    private static final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final char[] allowedChars = allowedString.toCharArray();
    private static final int base = allowedChars.length;

    public static String encode(long input){
        var encodedString = new StringBuilder();

        if(input == 0) {
            return String.valueOf(allowedChars[0]);
        }

        while (input > 0) {
            encodedString.append(allowedChars[(int) (input % base)]);
            input = input / base;
        }

        return encodedString.reverse().toString();
    }

    public static long decode(String input) {
        var characters = input.toCharArray();
        var length = characters.length;

        var decoded = 0;

        //counter is used to avoid reversing input string
        var counter = 1;
        for (char character : characters) {
            decoded += allowedString.indexOf(character) * Math.pow(base, length - counter);
            counter++;
        }
        return decoded;
    }
}
