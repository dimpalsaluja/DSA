package com.tiyoda.DynamicProgramming;

public class MinimumDifferenceSubsets {
    public static int findMinimumDifferenceBetweenSubsets(int[] arr, int n) {
        int sum = 0;
        for(int ele : arr)
            sum += ele;
        SubsetSumProblem.isSubsetWithGivenSumExistsMemoized(arr, sum/2, n);
        int[][] dp = SubsetSumProblem.dp;
        for(int j = sum/2; j >= 0; j -= 1) {
            if(dp[n][j] != 0)
                return sum - 2 * j;
        }
        return -1;
    }
}
