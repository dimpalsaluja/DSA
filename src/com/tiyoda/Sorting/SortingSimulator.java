package com.tiyoda.Sorting;

import com.tiyoda.Utils.InputUtil.ArrayInput;
import com.tiyoda.Utils.OutputUtil.ArrayOutput;

import java.io.IOException;

public class SortingSimulator {
    public static void main(String[] args)throws IOException {
        int[] arr = ArrayInput.readArray();
        int n = arr.length;
        /* BubbleSort.bubbleSort(arr, n);
        BubbleSort.recursiveBubbleSort(arr, n);
        SelectionSort.selectionSort(arr, n);
        SelectionSort.recursiveSelectionSort(arr, n); */
        //SelectionSort.stableSelectionSort(arr, n);
       // InsertionSort.insertionSort(arr, n);
        InsertionSort.insertionSortUsingBinarySearch(arr, n);
        ArrayOutput.printArray(arr);
    }
}
