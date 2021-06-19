package com.tiyoda.Leetcode;

import java.util.HashMap;

/***
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 */
public class FruitIntoBaskets {

    public static int totalFruit(int[] tree) {
        int length = tree.length;
        int i = 0, j = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j < length) {
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            if(map.size() <= 2) {
                if(j - i + 1 >= max)
                    max = j - i + 1;
            }
            while(map.size() > 2) {
                if(map.containsKey(tree[i])) {
                    map.put(tree[i], map.get(tree[i]) - 1);
                    if(map.get(tree[i]) == 0)
                        map.remove(tree[i]);
                }
                i += 1;
            }
            j += 1;
        }
        return max;
    }
}

/*** Variable Size Sliding Window - Aditya Verma
 * Same as Longest Substring with At Most Two Distinct Characters */