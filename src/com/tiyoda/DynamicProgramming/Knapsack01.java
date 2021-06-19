package com.tiyoda.DynamicProgramming;

import java.util.Arrays;

public class Knapsack01 {
    static int[][] dp;
    public static int maximizeProfitUsingRecursion(int[] wt, int[] p, int C, int n) {
        if(n == 0 || C == 0)
            return 0;
        int max = maximizeProfitUsingRecursion(wt, p, C, n - 1);
        if(wt[n - 1] <= C)
            max = Integer.max(max, maximizeProfitUsingRecursion(wt, p, C - wt[n - 1],
                    n - 1) + p[n - 1]);
        return max;
    }

    public static int maximizeProfitMemoized(int[] wt, int[] p, int C, int n) {
        dp = new int[n + 1][C + 1];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        return maximizeProfitMemoizedUtil(wt, p, C, n);
    }

    private static int maximizeProfitMemoizedUtil(int[] wt, int[] p, int C, int n) {
        if(C == 0 || n == 0)
            return 0;
        if(dp[n][C] != -1)
            return dp[n][C];
        int max = maximizeProfitMemoizedUtil(wt, p, C, n - 1);
        if(wt[n - 1] <= C)
            max = Integer.max(max, maximizeProfitMemoizedUtil(wt, p, C - wt[n - 1],
                    n - 1) + p[n - 1]);
        return dp[n][C] = max;
    }

    public static int maximizeProfitTabulated(int[] wt, int[] p, int C, int n) {
        dp = new int[n + 1][C + 1];
        for(int i = 1; i <= n; i += 1) {
            for(int j = 1; j <= C; j += 1) {
                dp[i][j] = dp[i - 1][j];
                if(wt[i - 1] <= j) {
                    dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j - wt[i - 1]] + p[i - 1]);
                }
            }
        }
        return dp[n][C];
    }
}
