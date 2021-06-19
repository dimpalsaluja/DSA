package com.tiyoda.Recursion;

public class SortAnArray {
    public static void sortArrayUsingRecursion(int[] arr, int n)
    {
        if(n <= 1)
            return;
        sortArrayUsingRecursion(arr, n - 1);
        insertAtSortedPositionUsingRecursion(arr, n - 1, arr[n - 1]);

    }
    private static void insertAtSortedPositionUsingRecursion(int[] arr, int n, int temp) {
        if(n == 0 || temp > arr[n - 1]) {
            arr[n] = temp;
            return;
        }
        int p = arr[n - 1];
        insertAtSortedPositionUsingRecursion(arr, n - 1, temp);
        arr[n] = p;
    }
}
