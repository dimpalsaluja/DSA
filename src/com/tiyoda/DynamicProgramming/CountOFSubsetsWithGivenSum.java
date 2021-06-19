package com.tiyoda.DynamicProgramming;

public class CountOFSubsetsWithGivenSum {
    static int[][] dp;
    public static int findCountOfSubsetsWithGivenSumUsingRecursion(int[] arr, int n, int sum) {
        if(n == 0)
            return sum == 0? 1 : 0;
        if(sum == 0)
            return 1;
        return findCountOfSubsetsWithGivenSumUsingRecursion(arr, n - 1, sum)
                + (arr[n - 1] <= sum ? findCountOfSubsetsWithGivenSumUsingRecursion(arr, n - 1,
                sum - arr[n - 1]) : 0);
    }

    public static int findCountOfSubsetsWithGivenSumMemoized(int[] arr, int n, int sum) {
        dp = new int[n + 1][sum + 1];
        return findCountOfSubsetsWithGivenSumMemoizedUtil(arr, n, sum);
    }
    private static int findCountOfSubsetsWithGivenSumMemoizedUtil(int[] arr, int n, int sum) {
        if(n == 0)
            return sum == 0? 1 : 0;
        if(sum == 0)
            return 1;
        if(dp[n][sum] != 0)
            return dp[n][sum];
        return dp[n][sum] =  findCountOfSubsetsWithGivenSumMemoizedUtil(arr, n - 1, sum)
                + (arr[n - 1] <= sum ? findCountOfSubsetsWithGivenSumMemoizedUtil(arr,
                n - 1, sum - arr[n - 1]) : 0);
    }

    public static int findCountOfSubsetsWithGivenSumTabulated(int[] arr, int n, int sum ) {
        dp = new int[n + 1][sum + 1];
        int z = 0;
        for(int i = 0; i <= n; i += 1) {
            if(i != n && arr[i] == 0)
                z += 1;
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i += 1) {
            for(int j = 1; j <= sum; j += 1) {
                dp[i][j] = dp[i - 1][j];
                if(arr[i - 1] != 0 && arr[i - 1] <= j)
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
            }
        }
        return (int)Math.pow(2, z) * dp[n][sum];
    }




}
