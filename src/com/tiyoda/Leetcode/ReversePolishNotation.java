package com.tiyoda.Leetcode;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPNUsingStack(String[] tokens) {
        int length = tokens.length, a, b;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < length; i += 1) {
            String temp = tokens[i];
            if(Character.isDigit(temp.charAt(temp.length() - 1)))
                stack.push(Integer.parseInt(temp));
            else {
                a = stack.pop();
                b = stack.pop();
                switch(temp) {
                    case "+" : stack.push(a + b);
                        break;
                    case "-" : stack.push(b -a);
                        break;
                    case "*" : stack.push(a * b);
                        break;
                    case "/" : stack.push(b / a);
                        break;
                }
            }
        }
        return stack.peek();
    }

    /***
     *Complexity Analysis
     *
     * Let n be the length of the list.
     *
     * Time Complexity : O(n).
     *
     * We do a linear search to put all numbers on the stack, and process all operators.
     * Processing an operator requires removing 2 numbers off the stack and replacing them
     * with a single number, which is an O(1) operation. Therefore, the total cost is
     * proportional to the length of the input array. Unlike before, we're no longer doing
     * expensive deletes from the middle of an Array or List.
     *
     * Space Complexity : O(n).
     *
     * In the worst case, the stack will have all the numbers on it at the same time.
     * This is never more than half the length of the input array.
     */

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int i = 0;
        while(n > 1) {
            if(!"+-*/".contains(tokens[i])) {
                i += 1;
            }
            else {
                int a = Integer.parseInt(tokens[i - 2]);
                int b = Integer.parseInt(tokens[i - 1]);
                int res = 0;
                switch(tokens[i])
                {
                    case "+" : res = (a + b);
                        break;
                    case "-" : res = (a - b);
                        break;
                    case "*" : res = (a * b);
                        break;
                    case "/" : res = (a / b);
                        break;
                }
                tokens[i] = String.valueOf(res);
                for(int j = i - 2; j < n - 2; j += 1) {
                    tokens[j] = tokens[j + 2];
                }
                n -= 2;
                i -= 1;
            }
        }
        return Integer.parseInt(tokens[0]);
    }
}

/***
 * In-place solution
 *
 * Complexity Analysis
 *
 * Let n be the length of the list.
 *
 * Time Complexity : O(n^2)
 *
 * Firstly, it helps to calculate how many operators and how many numbers are in the
 * initial list. Each step of the algorithm removes 1 operator, 2 numbers, and adds back 1 number.
 * This is an overall loss of 1 number and 1 operator per step. At the end, we have 1 number left.
 * Therefore, we can infer that at the start, there must always be exactly 1 more number than there
 * is operators.
 *
 * The big inefficiency of this approach is more obvious in the Java code than the Python.
 * Deleting an item from an ArrayList or Array is O(n), because all the items after have to be
 * shuffled down one place to fill in the gap. The number of these deletions we need to do is
 * the same as the number of operators, which is proportional to n. Therefore, the cost of the
 * deletions is O(n^2)
 * This is more obvious in the Java code, because we had to define the deletion method ourselves.
 * However, the Python deletion method works the same way, it's just that you can't see it because
 * it's hidden in a library function call. It's important to always be aware of the cost of library
 * functions as they can sometimes look like they're O(1) when they're not!
 *
 * Space Complexity : O(1).
 *
 * The only extra space used is a constant number of single-value variables. Therefore, the overall
 * algorithm requires O(1) space.
 *
 * Interestingly, this approach could be adapted to work with a Double-Linked List. It would require
 * O(n) space to create the list, and then take O(n) time to process it using a similar algorithm to
 * above. This works because the algorithm is traversing the list in a linear fashion and modifications
 * only impact the tokens immediately to the left of the current token.
 *
 */



