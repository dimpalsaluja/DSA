package com.tiyoda.Recursion;

import com.tiyoda.Utils.InputUtil.Input;

import java.io.IOException;

public class RecursionSimulator {
    public static void main(String[] args)throws IOException {
       // int[] arr = ArrayInput.readArray();
       // SortAnArray.sortArrayUsingRecursion(arr, arr.length);
       // ArrayOutput.printArray(arr);
        //Stack<Integer> stack = StackInput.readStack();
        //SortAStack.sortAStackUsingRecursion(stack);
        //DeleteMiddleElementOfStack.deleteMiddleElementOFStack(stack);
        //ReverseAStack.reverseAStackUsingRecursion(stack);
        //StackOutput.printStack(stack);
        String str = Input.readInput();
        //PrintAllSubsequences.printAllSubsequence(str);
        //PrintSubsequencesWithSpace.printSubsequencesWithSpace(str);
        //PrintSubsequencesWithCaseChange.printSubsequencesWithCaseChange(str);
        PrintSubsequencesWithCaseChange.letterCasePermutation(str);
    }
}
