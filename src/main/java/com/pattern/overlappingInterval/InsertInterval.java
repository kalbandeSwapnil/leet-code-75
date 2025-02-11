package com.pattern.overlappingInterval;

import java.util.Arrays;

/*
57. Insert Interval
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

 */
public class InsertInterval {


    /*
    Time complexity : O(n)
    Space complexity : O(n)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        int[][] result = new int[n + 1][2];
        int index = 0;

        while (i < n && intervals[i][1] < start) {
            result[index++] = intervals[i];
            i++;
        }

        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        result[index++] = new int[]{start, end};

        while (i < n) {
            result[index++] = intervals[i++];
        }

        return Arrays.copyOf(result, index);


    }

    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();
        int[][] result = obj.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int[] res : result) {
            System.out.println(Arrays.toString(res)); // [1, 5] [6, 9]
        }
    }

    /*
     for(int i=0 ;i< intervals.length;i++){
           int start = intervals[i][0];
           int end = intervals[i][1];

           if(newInterval[0] > end) {
               continue;
           }
           else {
               if(newInterval[1] < start) {
                   return Arrays.copyOf(intervals, intervals.length+1);
               }
               else {
                   newInterval[0] = Math.min(newInterval[0], start);
                   newInterval[1] = Math.max(newInterval[1], end);
               }
           }
       }
         return new int[][]{newInterval};
     */
}
