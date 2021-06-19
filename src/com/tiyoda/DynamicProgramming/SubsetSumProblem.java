package com.tiyoda.DynamicProgramming;

import java.util.Arrays;

public class SubsetSumProblem {
    static int[][] dp;
    public static boolean isSubsetWithGivenSumExistsUsingRecursion(int[] arr, int sum, int n) {
        if(n == 0)
            return sum == 0;
        if(sum == 0)
            return true;
        return isSubsetWithGivenSumExistsUsingRecursion(arr, sum, n - 1)
                || (arr[n - 1] <= sum && isSubsetWithGivenSumExistsUsingRecursion(arr,
                sum - arr[n - 1], n - 1));
    }

    public static boolean isSubsetWithGivenSumExistsMemoized(int[] arr, int sum, int n) {
        dp = new int[n + 1][sum + 1];
        for(int[] a : dp)
            Arrays.fill(a, -1);
        return isSubsetWithGivenSumExistsMemoizedUtil(arr, sum, n);
    }

    private static boolean isSubsetWithGivenSumExistsMemoizedUtil(int[] arr, int sum, int n) {
        if(n == 0)
            return sum == 0;
        if(sum == 0)
            return true;
        if(dp[n][sum] != -1)
            return dp[n][sum] == 1;
        boolean res = isSubsetWithGivenSumExistsMemoizedUtil(arr, sum, n - 1)
                || (arr[n - 1] <= sum && isSubsetWithGivenSumExistsMemoizedUtil(arr,
                sum - arr[n - 1], n - 1));
        dp[n][sum] = res ? 1 : 0;
        return res;
    }

    public static boolean isSubsetWithGivenSumExistsTabulated(int[] arr, int sum, int n) {
        boolean[][] dp2 = new boolean[n + 1][sum + 1];
        for(int i = 0; i <= n; i += 1) {
            dp2[i][0] = true;
        }

        for(int i = 1; i <= n; i += 1) {
            for(int j = 1; j <= sum; j += 1) {
                dp2[i][j] = dp2[i - 1][j];
                if(arr[i - 1] <= j)
                    dp2[i][j] = dp2[i][j] || dp2[i - 1][j - arr[i - 1]];
            }
        }
        return dp2[n][sum];
    }
}
