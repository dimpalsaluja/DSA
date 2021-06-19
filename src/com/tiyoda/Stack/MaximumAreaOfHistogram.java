package com.tiyoda.Stack;

import java.util.Stack;

public class MaximumAreaOfHistogram {
    public static int findMaximumAreaRectangle(int[] heights, int n) {
        int maxArea = 0;
        for(int i = 0; i < n; i += 1){
            int minHeight = Integer.MAX_VALUE;
            for(int j = i; j < n; j += 1) {
                minHeight = Integer.min(minHeight, heights[j]);
                int width = j - i + 1;
                maxArea = Integer.max(maxArea, minHeight * width);
            }
        }
        return maxArea;
    }

    public static int findMaximumAreaOfRectangleUsingStack(int[] heights, int n) {
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        int max = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i += 1) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.empty())
                nsl[i] = -1;
            else
                nsl[i] = stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();

        for(int i = n - 1; i >= 0; i -= 1) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.empty())
                nsr[i] = n;
            else
                nsr[i] = stack.peek();
            stack.push(i);
        }

        for(int i = 0; i < n; i += 1) {
            int curr = (nsr[i] - nsl[i] - 1) * heights[i];
            max = Integer.max(max, curr);

        }
        return max;
    }
}
