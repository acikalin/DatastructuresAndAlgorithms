package com.coding.algorithms.sorting.utils;

public class Util {

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void printArray(int[] array, String str) {
        System.out.println(str);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
