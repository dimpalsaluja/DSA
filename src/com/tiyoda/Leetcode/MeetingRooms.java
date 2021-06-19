package com.tiyoda.Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 */

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i += 1) {
            if(!queue.isEmpty() && intervals[i][0] >= queue.peek())
                queue.poll();
            queue.add(intervals[i][1]);
        }
        return queue.size();
    }
}

/***
 * Algorithm
 *
 * Sort the given meetings by their start time.
 * Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep
 * track of the ending times as that tells us when a meeting room will get free.
 * For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap
 * is free or not.
 * If the room is free, then we extract the topmost element and add it back with the ending time of the
 * current meeting we are processing.
 * If not, then we allocate a new room and add it to the heap.
 * After processing all the meetings, the size of the heap will tell us the number of rooms
 * allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
 */

/***
 * Complexity Analysis
 *
 * Time Complexity: O(NlogN).
 *
 * There are two major portions that take up time here. One is sorting of the array that takes
 * O(NlogN) considering that the array consists of N elements.
 * Then we have the min-heap. In the worst case, all N meetings will collide with each other.
 * In any case we have N add operations on the heap. In the worst case we will have N extract-min
 * operations as well. Overall complexity being (NlogN) since extract-min operation on a heap takes
 * O(logN).
 * Space Complexity: O(N) because we construct the min-heap and that can contain
 * N elements in the worst case as described above in the time complexity section.
 * Hence, the space complexity is O(N).
 */