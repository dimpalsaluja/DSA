package com.tiyoda.Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/***
 * Given a list of words, each word consists of English lowercase letters.
 *
 * Let's say word1 is a predecessor of word2 if and only if we
 * can add exactly one letter anywhere in word1 to make it equal to word2.
 * For example, "abc" is a predecessor of "abac".
 *
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1,
 * where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 *
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chain is "a","ba","bda","bdca".
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int  n = words.length;
        if(n <= 1)
            return n;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s, String t) {
                return s.length() - t.length();
            }
        });
        Map<String, Integer> map = new HashMap<>();
        int max = 1;
        for(String word : words) {
            int currLength = 1;
            int l = word.length();
            for(int i = 0; i < l; i += 1) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String pred = sb.toString();
                currLength = Integer.max(currLength, map.getOrDefault(pred, 0) + 1);
            }
            map.put(word, currLength);
            max = Integer.max(max, currLength);
        }
        return max;
    }
}

/***
 *
 * Bottom Up DP Approach
 * Complexity Analysis
 *
 * Let N be the number of words in the list and L be the maximum possible length of a word.
 *
 * Time complexity: O(N⋅(logN+L^ 2))
 *
 *
 * Sorting a list of size N takes O(NlogN) time. Next, we use two for loops in which the outer
 * loop runs for O(N) iterations and the inner loop runs for O(L ^ 2)
 *  iterations in the worst case scenario. The first L is for the inner loop and the second L
 *  is for creating each predecessor. Thus the overall time complexity is O(NlogN+(N⋅L ^ 2))
 *
 * Space complexity: O(N).
 *
 * We use a map to store the length of the longest sequence formed with
 * each of the N words as the end word.
 */
