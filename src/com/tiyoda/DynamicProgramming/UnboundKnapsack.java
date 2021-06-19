package com.tiyoda.DynamicProgramming;

public class UnboundKnapsack {
    static int[][] dp;
    public static int maximizeProfitUsingRecursion(int[] wt, int[] p, int C, int n) {
        if(C == 0 || n == 0)
            return 0;
        int notInclude = maximizeProfitUsingRecursion(wt, p, C, n - 1);
        if(wt[n - 1] <= C)
            notInclude = Integer.max(notInclude, p[n - 1] + maximizeProfitUsingRecursion(wt, p,
                    C - wt[n - 1], n));
        return notInclude;
    }

    public static int maximizeProfitMemoized(int[] wt, int[] p, int C, int n) {
        dp = new int[n + 1][C + 1];
        return maximizeProfitMemoizedUtil(wt, p, C, n);
    }

    private static int maximizeProfitMemoizedUtil(int[] wt, int[] p, int C, int n) {
        if(C == 0 || n == 0)
            return 0;
        if(dp[n][C] != 0)
            return dp[n][C];
        int notInclude = maximizeProfitMemoizedUtil(wt, p, C, n - 1);
        if(wt[n - 1] <= C)
            notInclude = Integer.max(notInclude, p[n - 1] +  maximizeProfitMemoizedUtil(wt, p,
                    C - wt[n - 1], n));
        return dp[n][C] = notInclude;
    }

    public static int maximizeProfitTabulated(int[] wt, int[] p, int C, int n) {
        dp = new int[n + 1][C + 1];
        for(int i = 1; i <= n; i += 1) {
            for(int j = 1; j <= C; j += 1) {
                dp[i][j] = dp[i - 1][j];
                if(wt[i - 1] <= j)
                    dp[i][j] = Integer.max(dp[i][j], dp[i][j - wt[i - 1]] + p[i - 1]);
            }
        }
        return dp[n][C];
    }


}
