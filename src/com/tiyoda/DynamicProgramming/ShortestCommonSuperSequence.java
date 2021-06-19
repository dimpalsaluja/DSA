package com.tiyoda.DynamicProgramming;

import com.tiyoda.Utils.OutputUtil.Output;

public class ShortestCommonSuperSequence {
    public static void printLongestCommonSubsequenceTabulated(String s1, String s2) {
        LongestCommonSubsequence.findLengthOfLongestCommonSubsequenceTabulated(s1, s2);
        int[][] dp = LongestCommonSubsequence.dp;
        StringBuilder res = new StringBuilder("");
        int i = s1.length(), j = s2.length();
        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                res.append(s1.charAt(i -  1));
                i -= 1;
                j -= 1;
            }
            else if(dp[i][j - 1] >= dp[i - 1][j]){
                res.append(s2.charAt(j - 1));
                j -= 1;
            }
            else {
                res.append(s1.charAt(i - 1));
                i -= 1;
            }
        }
        while(i > 0)
        {
            res.append(s1.charAt(i - 1));
            i -= 1;
        }
        while(j > 0) {
            res.append(s2.charAt(j - 1));
            j -= 1;
        }
        Output.printObject(res.reverse().toString());
    }
}
