package com.aston.lesson1hw;

public class TurnString {

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";

    public static void main(String[] args) {
        String string = "I love Java";

        turnString(string);
        turnStringAnotherMethod(string);
    }

    /** Первый способ **/
    public static void turnString(String string) {
        if (string.isEmpty()) {
            throw new NullPointerException();
        } else {
            String turnedString = "";
            for (int i = 0; i < string.length(); i++) {
                turnedString = turnedString + string.charAt(string.length() - 1 - i);
            }
            System.out.println(turnedString);
        }
    }

    /** Второй способ **/
    public static void turnStringAnotherMethod(String string) {
        if (string.isEmpty()) {
            throw new NullPointerException();
        } else {
            String turnedString = new StringBuilder(string).reverse().toString();
            System.out.println(turnedString);
        }
    }
}
