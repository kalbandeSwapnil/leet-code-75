package com.pattern.twopointer.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 Notice that the solution set must not contain duplicate triplets.

 Example 1:

 Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

 */
public class Sum3 {

    /*
    Time Complexity: O(n^2)
    Space Complexity: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, result);
            }
        }

        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int low = i + 1;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                high--;

                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }

                while (low < high && nums[high] == nums[high + 1]) {
                    high--;
                }
            } else if (sum < 0) {
                low++;
            } else {
                high--;
            }
        }
    }

    public static void main(String[] args) {
        Sum3 sum3 = new Sum3();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = sum3.threeSum(nums);
        System.out.println(result);
    }
}
