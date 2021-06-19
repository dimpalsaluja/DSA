package com.tiyoda.Recursion;

import com.tiyoda.Utils.OutputUtil.ArrayOutput;

import java.util.ArrayList;

public class PrintSubsequencesWithSpace {
    static ArrayList<String> res = new ArrayList<>();
    public static void printSubsequencesWithSpace(String str) {
        printSubsequencesWithSpaceUtil(str, "");
        ArrayOutput.printArrayList(res);
    }

    private static void printSubsequencesWithSpaceUtil(String str, String output) {
        if(str.equals(""))
        {
            res.add(output);
            return;
        }
        char currChar = str.charAt(0);
        if(str.length() == 1) {
            res.add(output + currChar);
            return;
        }
        String nextInput = str.substring(1);
        output += currChar;
        printSubsequencesWithSpaceUtil(nextInput, output + " ");
        printSubsequencesWithSpaceUtil(nextInput, output);
    }


}
