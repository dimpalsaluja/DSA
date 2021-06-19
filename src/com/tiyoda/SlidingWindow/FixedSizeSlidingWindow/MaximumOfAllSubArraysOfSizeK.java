package com.tiyoda.SlidingWindow.FixedSizeSlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaximumOfAllSubArraysOfSizeK {
    public static ArrayList<Integer> findMaximumOfAllSubArraysOfGivenSize(int[] arr, int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(j < n) {
            if(dq.isEmpty())
                dq.add(arr[j]);
            else {
                while(!dq.isEmpty() && arr[j] > dq.getLast()) {
                    dq.removeLast();
                }
                dq.add(arr[j]);
            }
            if(j - i + 1 == k) {
                if(dq.isEmpty())
                    res.add(0);
                else
                    res.add(dq.getFirst());
                if(dq.getFirst() == arr[i])
                    dq.removeFirst();
                i += 1;
            }
            j += 1;
        }
        return res;
    }
}
