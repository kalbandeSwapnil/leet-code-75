package com.pattern.prefixsum;

import java.util.HashMap;
import java.util.Map;


/*
560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */
public class SubArraySum {

    public int subArraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            sum += num;

            // Check if (sum - k) exists in the map
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }

            // Add the current sum to the map
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubArraySum sol = new SubArraySum();
        int[] nums = {1, 2, 3};

        int result = sol.subArraySum(nums, 3);
        System.out.println(result);
    }
}