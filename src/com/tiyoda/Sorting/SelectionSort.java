package com.tiyoda.Sorting;

import com.tiyoda.Utils.ArrayUtils;

public class SelectionSort {
    public static void selectionSort(int[] arr, int n) {
        for(int i = 0; i < n - 1; i += 1) {
            /* Till n - 1 because as soon as we place the second last element at correct position,
             the entire array gets sorted. */
            int iThMinimumElement = ArrayUtils.findMinimumInArrayFromGivenStartIndex(arr, i, n);
            ArrayUtils.swap(arr, i, iThMinimumElement);
        }
    }

    public static void recursiveSelectionSort(int[] arr, int n) {
        if(n <= 1) {
            return;
        }
        ArrayUtils.swap(arr, n - 1, ArrayUtils.findMaximumInArray(arr, n));
        recursiveSelectionSort(arr, n - 1);
    }

    public static void stableSelectionSort(int[] arr, int n) {
        for(int i = 0; i < n - 1; i += 1) {
            int iThMinimumElement = ArrayUtils.findMinimumInArrayFromGivenStartIndex(arr, i, n);
            ArrayUtils.insertAtGivenIndex(arr, i, iThMinimumElement, arr[iThMinimumElement]);
            //Instead of swapping insert at correct position and shift all remaining elements
        }
    }


}
