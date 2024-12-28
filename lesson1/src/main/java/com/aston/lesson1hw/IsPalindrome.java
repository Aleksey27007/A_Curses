package com.aston.lesson1hw;

public class IsPalindrome {

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true

    public static void main(String[] args) {
        String[] textArray = {"abc", "112233", "aba", "112211"};

        System.out.println(isPalindrome(textArray[0]));  // false
        System.out.println(isPalindrome(textArray[1]));  // false
        System.out.println(isPalindrome(textArray[2]));  // true
        System.out.println(isPalindrome(textArray[3]));  // true
        System.out.println(isPalindrome("assa"));  // true
        System.out.println(isPalindrome("12345543231"));  // false
    }

    public static boolean isPalindrome(String string) {
        boolean result = false;

        for (int i = 0; i < string.length()/2; i++) {
            if (string.charAt(i) == string.charAt(string.length() - 1 - i)) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
