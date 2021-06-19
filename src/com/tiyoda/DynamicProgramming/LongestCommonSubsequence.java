package com.tiyoda.DynamicProgramming;

import com.tiyoda.Utils.OutputUtil.Output;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static int[][] dp;
    public static int findLengthOfLongestCommonSubsequenceUsingRecursion(String s1, String s2) {
        return findLengthOfLongestCommonSubsequenceUsingRecursionUtil(s1, s2, s1.length(), s2.length());
    }

    private static int findLengthOfLongestCommonSubsequenceUsingRecursionUtil(String s1, String s2, int m, int n) {
        if(n == 0 || m == 0)
            return 0;
        if(s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + findLengthOfLongestCommonSubsequenceUsingRecursionUtil(s1, s2, m - 1, n - 1);
        else
            return Integer.max(findLengthOfLongestCommonSubsequenceUsingRecursionUtil(s1, s2, m, n - 1),
                    findLengthOfLongestCommonSubsequenceUsingRecursionUtil(s1, s2, m - 1, n));
    }

    public static int findLengthOfLongestCommonSubsequenceMemoized(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m + 1][n + 1];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        return findLengthOfLongestCommonSubsequenceMemoizedUtil(s1, s2, s1.length(), s2.length());
    }

    private static int findLengthOfLongestCommonSubsequenceMemoizedUtil(String s1, String s2, int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(dp[m][n] != -1)
            return dp[m][n];
        if(s1.charAt(m - 1) == s2.charAt(n - 1))
            return dp[m][n] = 1 + findLengthOfLongestCommonSubsequenceMemoizedUtil(s1, s2, m - 1, n - 1);
        else
            return dp[m][n] = Integer.max(findLengthOfLongestCommonSubsequenceMemoizedUtil(s1, s2, m, n - 1),
                    findLengthOfLongestCommonSubsequenceMemoizedUtil(s1, s2, m - 1, n));
    }

    public static int findLengthOfLongestCommonSubsequenceTabulated(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i += 1) {
            for(int j = 1; j <= n; j += 1) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Integer.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }

    public static void printLongestCommonSubsequenceTabulated(String s1, String s2) {
        findLengthOfLongestCommonSubsequenceTabulated(s1, s2);
        StringBuilder res = new StringBuilder("");
        int i = s1.length(), j = s2.length();
        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                res.append(s1.charAt(i - 1));
                i -= 1;
                j -= 1;
            }
            else if(dp[i][j - 1] >= dp[i - 1][j]){
                j -= 1;
            }
            else
                i -= 1;
        }
        Output.printObject(res.reverse().toString());
    }

}
