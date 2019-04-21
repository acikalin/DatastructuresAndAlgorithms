package com.coding.algorithms.sorting;

import com.coding.algorithms.sorting.utils.Util;

public class BubbleSort {
    static void sort(int[] arrayToSort) {
        Util.printArray(arrayToSort, "Initial");
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    Util.swap(arrayToSort, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        Util.printArray(arrayToSort, "Final");
    }

    // Driver code
    public static void main(String[] args) {
        int[] arrayToSort = {1, 5, 6, 4, 2, 7, 10, 3, 8, 9};
        BubbleSort.sort(arrayToSort);
    }
}
