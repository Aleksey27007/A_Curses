package com.aston.lesson1hw;

import java.util.Arrays;

public class DistinctNumbers {
    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};

        getDistinctNumbers(ints);
        System.out.println();
        getDistinctNumbersAnotherMethod(ints);
    }
    /** Первый способ **/
    public static void getDistinctNumbers(int[] ints) {
        int[] cleanedArray = Arrays.stream(ints)
                .distinct()
                .toArray();

        for (int elem : cleanedArray) {
            System.out.print(elem + " ");
        }
    }
    /** Второй способ **/
    public static void getDistinctNumbersAnotherMethod(int[] ints) {
        int[] uniqueInts = new int[ints.length];
        int uniqueCount = 0;

        for (int i = 0; i < ints.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (ints[i] == uniqueInts[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueInts[uniqueCount] = ints[i];
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = uniqueInts[i];
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
