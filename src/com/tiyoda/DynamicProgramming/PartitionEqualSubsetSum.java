package com.tiyoda.DynamicProgramming;

public class PartitionEqualSubsetSum {
    public static boolean isExistsTwoPartitionsWithEqualSum(int[] arr, int n) {
        int sum = 0;
        for(int ele : arr)
            sum += ele;
        if(sum % 2 != 0)
            return false;
        return SubsetSumProblem.isSubsetWithGivenSumExistsTabulated(arr, sum/2, n);
    }
}
