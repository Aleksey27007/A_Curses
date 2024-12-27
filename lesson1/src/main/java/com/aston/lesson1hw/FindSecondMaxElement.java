package com.aston.lesson1hw;

public class FindSecondMaxElement {
    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.

    public static void main(String[] args) {
        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};

        System.out.println(findSecondMaxElement(arr));
    }

    public static Integer findSecondMaxElement(int[] arr){
        int maxElem = 0;
        int secondMaxElem = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxElem < arr[i]) {
                maxElem = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (secondMaxElem < arr[i] && arr[i] != maxElem) {
                secondMaxElem = arr[i];
            }
        }

        return secondMaxElem;
    }
}
