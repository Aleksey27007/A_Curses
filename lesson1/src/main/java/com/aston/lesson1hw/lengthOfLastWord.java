package com.aston.lesson1hw;

public class lengthOfLastWord {

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4

    public static void main(String[] args) {
        String text1 = "Hello world";
        String text2 = "    fly me    to the moon    ";

        System.out.println(lengthOfLastWord(text1));
        System.out.println(lengthOfLastWord(text2));
    }

    public static Integer lengthOfLastWord(String string) {
        String trimString = string.trim();

        String[] words = trimString.split(" ");

        return words[words.length - 1].length();
    }
}
