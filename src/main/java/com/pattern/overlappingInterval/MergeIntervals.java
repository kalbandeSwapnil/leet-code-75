package com.pattern.overlappingInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

 */
public class MergeIntervals {


    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int[] interval = intervals[i];
            if(interval[0] <= end){
                end = Math.max(end, interval[1]);
            }else{
                mergedIntervals.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        mergedIntervals.add(new int[]{start, end});

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

    }
}
