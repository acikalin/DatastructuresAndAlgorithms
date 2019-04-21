package com.coding.algorithms.sorting;

import com.coding.algorithms.sorting.utils.Util;

public class SelectionSort {
    static void sort(int[] arrayToSort) {
        Util.printArray(arrayToSort, "Initial");
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (arrayToSort[i] > arrayToSort[j]) {
                    Util.swap(arrayToSort, i, j);
                }
            }
        }
        Util.printArray(arrayToSort, "Final");
    }

    // Driver code
    public static void main(String[] args) {
        int[] arrayToSort = {1, 5, 6, 4, 2, 7, 10, 3, 8, 9};
        SelectionSort.sort(arrayToSort);
    }
}