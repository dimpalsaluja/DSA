package com.tiyoda.Leetcode;

/***
 * You are given an array of positive integers w where w[i] describes the weight of ith
 * index (0-indexed).
 *
 * We need to call the function pickIndex() which randomly returns an integer in the range
 * [0, w.length - 1]. pickIndex() should return the integer proportional to its weight in the
 * w array. For example, for w = [1, 3], the probability of picking the index 0 is 1 / (1 + 3) = 0.25
 * (i.e 25%) while the probability of picking the index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).
 *
 * More formally, the probability of picking index i is w[i] / sum(w).
 */
public class RandomPickWithWeight {
    int[] prefixSum;
    int total;
    int n;

    public RandomPickWithWeight(int[] w) {
        this.n = w.length;
        prefixSum = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i += 1) {
            sum += w[i];
            this.prefixSum[i] = sum;
        }
        this.total = sum;
    }

    public int pickIndex() {        //Can also use linear search
        double target = total * Math.random();
        int low = 0, high = n - 1, res = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(prefixSum[mid] >= target) {
                res = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return res;

    }
}

/***
 * We now should have all the elements at hand for the implementation.
 *
 * First of all, before picking an index, we should first set up the playground, by generating a list
 * of prefix sums from a given list of numbers. The best place to do so would be in the constructor
 * of the class, so that we don't have to generate it again and again at the invocation of pickIndex()
 * function.
 *
 * In the constructor, we should also keep the total sum of the input numbers, so that later we could
 * use this total sum to scale up the random number.
 * For the pickIndex() function, here are the steps that we should perform.
 *
 * Firstly, we generate a random number between 0 and 1. We then scale up this number, which will
 * serve as our target offset.
 *
 * We then scan through the prefix sums that we generated before by binary search, to find the first
 * prefix sum that is larger than our target offset.
 *
 * And the index of this prefix sum would be exactly the right place that the target should fall into.
 * We return the index as the result of pickIndex() function.
 */


/***
 * Complexity Analysis
 *
 * Let N be the length of the input list.
 *
 * Time Complexity
 *
 * For the constructor function, the time complexity would be O(N), which is due to the construction
 * of the prefix sums.
 *
 * For the pickIndex() function, its time complexity would be O(log N) as well, since we did a
 * binary search on the prefix sums.
 *
 * Space Complexity
 *
 * For the constructor function, the space complexity would be O(N), which is again due to the
 * construction of the prefix sums.
 *
 * For the pickIndex() function, its space complexity would be O(1), since it uses constant memory.
 * Note, here we consider the prefix sums that it operates on, as the input of the function.
 */
