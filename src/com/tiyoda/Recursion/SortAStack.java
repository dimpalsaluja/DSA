package com.tiyoda.Recursion;

import java.util.Stack;

public class SortAStack {
    public static void sortAStackUsingRecursion(Stack<Integer> stack) {
        if(stack.empty())
            return;
        int temp = stack.pop();
        sortAStackUsingRecursion(stack);
        insertInSortedStack(stack, temp);
    }

    private static void insertInSortedStack(Stack<Integer> stack, int elementToBeInserted) {
        if(stack.empty() || elementToBeInserted >= stack.peek()) {
            stack.push(elementToBeInserted);
            return;
        }
        int temp = stack.pop();
        insertInSortedStack(stack, elementToBeInserted);
        stack.push(temp);
    }
}
