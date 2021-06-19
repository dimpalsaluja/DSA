package com.tiyoda.Sorting;

import com.tiyoda.Utils.ArrayUtils;

public class InsertionSort {
    public static void insertionSort(int[] arr, int n) {
        for(int i = 0; i < n; i += 1) {
            int j = i - 1, t = arr[i];
            while(j >= 0 && t < arr[j]) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = t;
        }
    }

    public static void insertionSortUsingBinarySearch(int[] arr, int n) {
        for(int i = 0; i < n; i += 1) {
            int insertionPoint = ArrayUtils.findInsertionPointUsingBinarySearch(arr, 0, i - 1, arr[i]);
            int temp = arr[i];
            for(int j = i - 1; j >= insertionPoint; j -= 1) {
                arr[j + 1] = arr[j];
            }
            arr[insertionPoint] = temp;
        }
    }
}
