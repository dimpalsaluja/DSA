package com.tiyoda.DynamicProgramming;

public class LongestCommonSubstring {
    static int max = 0;
    public static int findLengthOfLongestCommonSubstring(String m, String n) {
        findLengthOfLongestCommonSubstringUtil(m, n, m.length(), n.length());
        return max;
    }

    private static int findLengthOfLongestCommonSubstringUtil(String m, String n, int ml, int nl) {
        if(ml == 0 || nl == 0)
            return 0;
        int count = 0;
        if(m.charAt(ml - 1) == n.charAt(nl - 1))
            count = findLengthOfLongestCommonSubstringUtil(m, n, ml - 1, nl - 1) + 1;
        else {
            findLengthOfLongestCommonSubstringUtil(m, n, ml - 1, nl);
            findLengthOfLongestCommonSubstringUtil(m, n, ml, nl -1);
        }
        max = Integer.max(max, count);
        return count;
    }

}
