package com.coding.algorithms.sorting;

import com.coding.algorithms.sorting.utils.Util;

public class InsertionSort {
    static void sort(int[] arrayToSort) {
        Util.printArray(arrayToSort, "Initial");
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            for (int j = i; j > 0; j--) {
                if (arrayToSort[j + 1] > arrayToSort[j]) {
                    Util.swap(arrayToSort, j + 1, j);
                } else {
                    break;
                }
            }
        }
        Util.printArray(arrayToSort, "Final");
    }

    // Driver code
    public static void main(String[] args) {
        int[] arrayToSort = {1, 5, 6, 4, 2, 7, 10, 3, 8, 9};
        InsertionSort.sort(arrayToSort);
    }
}
