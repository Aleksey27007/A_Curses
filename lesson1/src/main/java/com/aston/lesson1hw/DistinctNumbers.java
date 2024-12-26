package com.aston.lesson1hw;

import java.util.Arrays;

public class DistinctNumbers {
    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};

        getDistinctNumbers(ints);
    }

    public static void getDistinctNumbers(int[] ints) {
        int[] cleanedArray = Arrays.stream(ints).distinct().toArray();

        for (int elem : cleanedArray) {
            System.out.print(elem + " ");
        }
    }
}
