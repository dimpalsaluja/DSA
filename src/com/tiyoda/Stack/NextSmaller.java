package com.tiyoda.Stack;

import java.util.Stack;

public class NextSmaller {
    public static int[] findNextSmallerToRight(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i -= 1) {
            while(!stack.empty() && stack.peek() >= arr[i])
                stack.pop();
            if(stack.empty())
                res[i] = -1;
            else
                res[i] = stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }

    public static int[] findNextSmallerToLeft(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i += 1) {
            while(!stack.empty() && stack.peek() >= arr[i])
                stack.pop();
            if(stack.empty())
                res[i] = -1;
            else
                res[i] = stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }
}
