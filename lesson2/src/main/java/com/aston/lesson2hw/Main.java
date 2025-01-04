package com.aston.lesson2hw;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);

        System.out.println("Before sorting:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        list.sort(Comparator.naturalOrder());

        System.out.println("\nAfter sorting:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
