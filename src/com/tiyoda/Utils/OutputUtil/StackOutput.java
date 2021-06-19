package com.tiyoda.Utils.OutputUtil;

import java.util.Stack;

public class StackOutput extends Output
{
    public static void printStack(Stack<Integer> stack) {
        while (!stack.empty()) {
            printObject(stack.pop());
        }
        printLine();
    }
}
