package com.tiyoda.SlidingWindow.FixedSizeSlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/***
 *
 * Given an array and a positive integer k, find the first negative integer for each window
 * (contiguous subArray) of size k. If a window does not contain a negative integer,
 * then print 0 for that window.
 *
 * Examples:
 *
 * Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 * Output : -8 0 -6 -6
 */

public class FirstNegativeNumberInWindowOfSizeK {
    public static ArrayList<Integer> findFirstNegativeNumberInEachWindowOfGivenSize(int[] arr, int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> negatives = new ArrayDeque<>();
        int i = 0, j = 0;
        while(j < n) {
            if(arr[j] < 0)
                negatives.addLast(arr[j]);
            if(j - i + 1 == k) {
                if(!negatives.isEmpty()) {
                    res.add(negatives.getFirst());
                    if(negatives.getFirst() == arr[i])
                        negatives.removeFirst();
                }
                else
                    res.add(0);
                i += 1;
            }
            j += 1;
        }
        return res;
    }

}
