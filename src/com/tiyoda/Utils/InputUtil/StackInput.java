package com.tiyoda.Utils.InputUtil;

import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackInput extends Input{
    private static StringTokenizer st;
    private static int numberOfTokens;

    public static void tokenize(String str) {
        st = new StringTokenizer(str);
        numberOfTokens = st.countTokens();
    }

    public static Stack<Integer> readStack() throws IOException {
        tokenize(readInput());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numberOfTokens; i += 1) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        return stack;
    }
}
