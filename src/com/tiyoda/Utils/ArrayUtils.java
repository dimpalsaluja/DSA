package com.tiyoda.Utils;

public class ArrayUtils {
    public static void swap(int[] arr, int i, int j) {
        if(i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static int findMinimumInArrayFromGivenStartIndex(int[] arr, int startIndex, int n) {
        int minIndex = startIndex;
        for(int i = startIndex + 1; i < n; i += 1) {
            if(arr[i] < arr[minIndex])
                minIndex = i;
        }
        return minIndex;
    }

    public static int findMaximumInArray(int[] arr, int n) {
        int maxIndex = n - 1;
        for(int i = n - 1; i >= 0; i -= 1) {
            if(arr[i] > arr[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }

    public static void insertAtGivenIndex(int[] arr, int positionOfInsertion,
                                          int endPoint, int elementToBeInserted) {
      //  if (endPoint - positionOfInsertion >= 0)  System.arraycopy(arr, positionOfInsertion, arr, positionOfInsertion + 1, endPoint - positionOfInsertion);
        if(endPoint == positionOfInsertion)
            return;
        for(int i = endPoint; i > positionOfInsertion; i -= 1) {
            arr[i] = arr[i - 1];
        }
        arr[positionOfInsertion] = elementToBeInserted;
    }

    public static int findInsertionPointUsingBinarySearch(int[] arr, int l, int r, int ele) {
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(arr[mid] == ele)
                return mid;
            else if(arr[mid] < ele)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
