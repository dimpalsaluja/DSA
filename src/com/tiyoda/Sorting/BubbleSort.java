package com.tiyoda.Sorting;

import com.tiyoda.Utils.ArrayUtils;

public class BubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        boolean swapped;
        for(int i = 0; i < n; i += 1) {
            swapped = false;
            for(int  j = 0 ; j < n - i - 1 ; j += 1) {
                if(arr[j] > arr[j + 1])
                {
                    swapped = true;
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
            if(!swapped)       //Check for no swaps which indicates the array is sorted
                break;
        }
    }

    //No performance and implementationAdvantages
    public static void recursiveBubbleSort(int[] arr, int n) {
        if(n == 1)
            return;
        for(int i = 0; i < n - 1; i += 1) {
            if(arr[i] > arr[i + 1])
                ArrayUtils.swap(arr, i, i + 1);
        }
        recursiveBubbleSort(arr, n - 1);
    }
}
