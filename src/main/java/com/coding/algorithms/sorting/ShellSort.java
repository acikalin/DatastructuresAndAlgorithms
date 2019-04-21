package com.coding.algorithms.sorting;

import com.coding.algorithms.sorting.utils.Util;

public class ShellSort {
    static void sort(int[] arrayToSort)
    {
        Util.printArray(arrayToSort, "Initial");
        int n = arrayToSort.length;
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arrayToSort[i];
                int j;
                for (j = i; j >= gap && arrayToSort[j - gap] > temp; j -= gap) {
                    arrayToSort[j] = arrayToSort[j - gap];
                }
                arrayToSort[j] = temp;
            }
        }
        Util.printArray(arrayToSort, "Final");
    }

    // Driver code
    public static void main(String[] args) {
        int[] arrayToSort = {1, 5, 6, 4, 2, 7, 10, 3, 8, 9};
        ShellSort.sort(arrayToSort);
    }
}
