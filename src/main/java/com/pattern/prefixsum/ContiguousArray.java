package com.pattern.prefixsum;

import java.util.HashMap;
import java.util.Map;
/*
525. Contiguous Array
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        ContiguousArray sol = new ContiguousArray();
        int[] nums1 = {0, 1};
        int[] nums2 = {0, 1, 0};

        System.out.println(sol.findMaxLength(nums1)); // Output: 2
        System.out.println(sol.findMaxLength(nums2)); // Output: 2
    }
}