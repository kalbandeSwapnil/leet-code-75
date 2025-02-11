package com.pattern.overlappingInterval;

import java.util.Arrays;

/*
435. Non-overlapping Intervals
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
Example 1:
Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.


 */
public class NonOverlappingInterval {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < end){
                count++;
                end = Math.min(end, intervals[i][1]);
            }else{
                end = intervals[i][1];
            }
        }

        return count;

    }

    public static void main(String[] args) {
        NonOverlappingInterval obj = new NonOverlappingInterval();
        System.out.println(obj.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}})); // 1
        
    }
}
