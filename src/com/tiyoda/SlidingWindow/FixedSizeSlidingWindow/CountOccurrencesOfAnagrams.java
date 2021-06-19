package com.tiyoda.SlidingWindow.FixedSizeSlidingWindow;

import java.util.HashMap;

/***
 * Given a word and a text, return the count of the occurrences of anagrams of the word in the text(For eg: anagrams of word for are for, ofr, rof etc.))
 *
 * Examples:
 *
 * Input : forxxorfxdofr
 *         for
 * Output : 3
 *
 * Explanation : Anagrams of the word for - for, orf,
 * ofr appear in the text and hence the count is 3.
 */
public class CountOccurrencesOfAnagrams {
    public  static int findCountOfOccurrencesOfAnagrams(String str, String pattern) {
        int length = pattern.length(), count = 0, i = 0, j = 0, strLength = str.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(i = 0; i < length; i += 1) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        i = 0;
        int countOfDistinctCharacters = map.size();
        while(j < strLength) {
            char d = str.charAt(j);
            if(map.containsKey(d)) {
                map.put(d, map.get(d) - 1);
                if(map.get(d) == 0)
                    countOfDistinctCharacters -= 1;
            }
            if(j - i + 1 == length) {
                if(countOfDistinctCharacters == 0)
                    count += 1;
                d = str.charAt(i);
                if(map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                    if(map.get(d) == 1)
                        countOfDistinctCharacters += 1;
                }
                i += 1;
            }
            j += 1;
        }
        return count;
    }
}
