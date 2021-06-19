package com.tiyoda.BinarySearch;

public class BinarySearch {
    public int findIndex(int[] arr, int n, int target, boolean ascending) {
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (ascending) {
                if (arr[mid] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                if (arr[mid] < target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }


}
