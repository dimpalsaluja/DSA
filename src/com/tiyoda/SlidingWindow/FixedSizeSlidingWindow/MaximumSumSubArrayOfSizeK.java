package com.tiyoda.SlidingWindow.FixedSizeSlidingWindow;

/***
 * Given an array of integers and a number k, find maximum sum of a subarray of size k.
 *
 * Examples :
 *
 * Input  : arr[] = {100, 200, 300, 400}
 *          k = 2
 * Output : 700
 *
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
 *          k = 4
 * Output : 39
 *
 * */
public class MaximumSumSubArrayOfSizeK {
    public static int findMaximumSumSubArrayOfGivenSize(int[] arr, int n, int k) {
        int i = 0, j = 0;
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        while(j < n) {
            currSum += arr[j];
            if(j - i + 1 == k) {
                if(currSum > maxSum)
                    maxSum = currSum;
                currSum -= arr[i];
                i += 1;
            }
            j += 1;
        }
        return maxSum;
    }
}
