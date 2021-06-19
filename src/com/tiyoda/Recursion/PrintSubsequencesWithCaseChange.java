package com.tiyoda.Recursion;

import com.tiyoda.Utils.OutputUtil.ArrayOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintSubsequencesWithCaseChange {
    static ArrayList<String> res = new ArrayList<>();
    public static void printSubsequencesWithCaseChange(String str) {
        printSubsequencesWithCaseChangeUtil(str, "");
        ArrayOutput.printArrayList(res);
    }

    private static void printSubsequencesWithCaseChangeUtil(String str, String output) {
        if(str.equals(""))
        {
            res.add(output);
            return;
        }
        char currChar = str.charAt(0), altChar=' ';
        if(currChar >= 65 && currChar <= 90)
            altChar = (char)(currChar + 32);
        else if(currChar >= 97 && currChar <= 122)
            altChar = (char)(currChar - 32);
        String nextInput = str.substring(1);
        printSubsequencesWithCaseChangeUtil(nextInput, output + currChar);
        if(altChar != ' ')
        printSubsequencesWithCaseChangeUtil(nextInput, output + altChar);
    }


    public static void letterCasePermutation(String s) {
        Queue<String> queue = new LinkedList<>();
        int n = s.length();
        queue.add("");
        for(int i = 0; i < n; i += 1) {
            int t = queue.size();
            char d = s.charAt(i);
            for(int j = 1; j <= t; j += 1) {
                String output = queue.poll();
                queue.add(output + d);
                if(Character.isLetter(d)) {
                    if(d >= 65 && d <= 90)
                        queue.add(output + (char)(d + 32));
                    else
                        queue.add(output + (char)(d - 32));
                }
            }
        }
        ArrayOutput.printArrayList(new ArrayList<>(queue));
    }
}
