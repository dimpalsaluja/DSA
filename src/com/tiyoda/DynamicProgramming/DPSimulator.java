package com.tiyoda.DynamicProgramming;

import com.tiyoda.Utils.InputUtil.ArrayInput;
import com.tiyoda.Utils.InputUtil.Input;
import com.tiyoda.Utils.OutputUtil.Output;

import java.io.IOException;

public class DPSimulator {
    public static void main(String[] args)throws IOException {
        //int n = Input.readInteger();
        //int[] arr1 = ArrayInput.readArray();
        //int[] arr2 = ArrayInput.readArray();
        //int k = Input.readInteger();
        String s1 = Input.readInput();
        String s2 = Input.readInput();
        //Output.printObject(Knapsack01.maximizeProfitUsingRecursion(arr1, arr2, k, n));
        //Output.printObject(Knapsack01.maximizeProfitMemoized(arr1, arr2, k, n));
        //Output.printObject(Knapsack01.maximizeProfitTabulated(arr1, arr2, k, n));
        /**Output.printObject(SubsetSumProblem.isSubsetWithGivenSumExistsUsingRecursion(arr1, k, n));
        Output.printObject(SubsetSumProblem.isSubsetWithGivenSumExistsMemoized(arr1, k, n));
        Output.printObject(SubsetSumProblem.isSubsetWithGivenSumExistsTabulated(arr1, k, n));*/
        //Output.printObject(PartitionEqualSubsetSum.isExistsTwoPartitionsWithEqualSum(arr1, n));
        /**Output.printObject(CountOFSubsetsWithGivenSum.findCountOfSubsetsWithGivenSumUsingRecursion(arr1, n, k));
        Output.printObject(CountOFSubsetsWithGivenSum.findCountOfSubsetsWithGivenSumMemoized(arr1, n, k));
        Output.printObject(CountOFSubsetsWithGivenSum.findCountOfSubsetsWithGivenSumTabulated(arr1, n, k));*/
        //Output.printObject(MinimumDifferenceSubsets.findMinimumDifferenceBetweenSubsets(arr1, n));
        /**Output.printObject(UnboundKnapsack.maximizeProfitUsingRecursion(arr1, arr2, k, n));
        Output.printObject(UnboundKnapsack.maximizeProfitMemoized(arr1, arr2, k, n));
        Output.printObject(UnboundKnapsack.maximizeProfitTabulated(arr1, arr2, k, n));*/
        //Output.printObject(LongestCommonSubstring.findLengthOfLongestCommonSubstring(Input.readInput(), Input.readInput()));
        /*Output.printObject(LongestCommonSubsequence.findLengthOfLongestCommonSubsequenceUsingRecursion(
                s1, s2));
        Output.printObject(LongestCommonSubsequence.findLengthOfLongestCommonSubsequenceMemoized(s1, s2));
        Output.printObject(LongestCommonSubsequence.findLengthOfLongestCommonSubsequenceTabulated(s1, s2));
        LongestCommonSubsequence.printLongestCommonSubsequenceTabulated(s1, s2);*/
        ShortestCommonSuperSequence.printLongestCommonSubsequenceTabulated(s1, s2);

    }
}
