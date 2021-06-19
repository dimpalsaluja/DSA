package com.tiyoda.Recursion;

import com.tiyoda.Utils.OutputUtil.ArrayOutput;

import java.util.ArrayList;

public class PrintAllSubsequences {
    static ArrayList<String> res = new ArrayList<>();
    //Use Set in Place of Array List to print Unique subsequences
    public static void printAllSubsequence(String str) {
        printAllSubsequenceUtil(str, "");
        ArrayOutput.printArrayList(res);
    }

    private static void printAllSubsequenceUtil(String input, String output) {
        if(input.equals("")) {
            res.add(output);
            return;
        }
        String nextInput = input.substring(1);
        char currChar = input.charAt(0);
        printAllSubsequenceUtil(nextInput, output + currChar);
        printAllSubsequenceUtil(nextInput, output);
    }

}
