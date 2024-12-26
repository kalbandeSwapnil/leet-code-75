package com.easy;


/*
643. Maximum Average Subarray I

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000


Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 */

public class MaximumAverageSubArray {

    public double findMaxAverage(int[] nums, int k) {

        double maxAverage = 0.0, windowAverage = 0.0;

        for (int i = 0; i < k; i++) {
            windowAverage += nums[i];
        }

        windowAverage = windowAverage / k;
        maxAverage = windowAverage;

        for (int i = k; i < nums.length; i++) {
            windowAverage = (windowAverage*k + nums[i] - nums[i - k])/k;
            maxAverage = Math.max(maxAverage, windowAverage);
        }

        return maxAverage;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 12, -5, -6, 50, 3}; //2+50-1  /4
        int k1 = 4;

        MaximumAverageSubArray maxNumberOfKSumPair = new MaximumAverageSubArray();

        System.out.println(maxNumberOfKSumPair.findMaxAverage(nums1, k1));
    }
}
