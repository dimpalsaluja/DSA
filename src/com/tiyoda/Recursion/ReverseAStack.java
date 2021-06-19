package com.tiyoda.Recursion;

import java.util.Stack;

public class ReverseAStack {
    public static void reverseAStackUsingRecursion(Stack<Integer> stack) {
        if(stack.empty())
            return;
        int temp = stack.pop();
        reverseAStackUsingRecursion(stack);
        insertAtBottom(stack, temp);
    }
    public static void insertAtBottom(Stack<Integer> stack, int elementToBeInserted) {
        if(stack.empty())
        {
            stack.push(elementToBeInserted);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, elementToBeInserted);
        stack.push(temp);
    }

}
