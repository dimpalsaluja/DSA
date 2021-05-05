package com.tiyoda.InputUtil;

import java.io.IOException;
import java.util.StringTokenizer;

public class ArrayInput extends Input{
    private static StringTokenizer st;
    private static int numberOfTokens;

    public static void tokenize(String str) {
        st = new StringTokenizer(str);
        numberOfTokens = st.countTokens();
    }

    public static int[] readArray() throws IOException {
        tokenize(readInput());
        int[] arr = new int[numberOfTokens];
        for(int i = 0; i < numberOfTokens; i += 1) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}
