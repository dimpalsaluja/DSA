package com.tiyoda.Recursion;

import java.util.Stack;

public class DeleteMiddleElementOfStack {
    public static void deleteMiddleElementOFStack(Stack<Integer> stack) {
        int n = stack.size();
        deleteMiddleElementOFStackUtil(stack, n/2 + 1);
    }

    private static void deleteMiddleElementOFStackUtil(Stack<Integer> stack, int n) {
        if(stack.size() == n)
        {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteMiddleElementOFStackUtil(stack, n);
        stack.push(temp);
    }
}
