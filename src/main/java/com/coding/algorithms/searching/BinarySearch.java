package com.coding.algorithms.searching;

public class BinarySearch {
    static int search(int[] sortedList, int number) {
        int min = 0;
        int max = sortedList.length - 1;
        int mid;
        while (max >= min) {
            mid = min + (max - min) / 2;
            if (sortedList[mid] == number)
                return number;
            if (sortedList[mid] > number)
                max = mid - 1;
            else
                min = mid + 1;
        }
        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        int numberToSearch =7;
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int returnedValue = BinarySearch.search(sortedArray, numberToSearch);
        if(returnedValue == numberToSearch)
            System.out.println("Number " + numberToSearch + " is found");
        else
            System.out.println("Number " + numberToSearch + " is not found");

    }
}
