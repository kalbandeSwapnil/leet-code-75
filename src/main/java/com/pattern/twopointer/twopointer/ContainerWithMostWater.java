package com.pattern.twopointer.twopointer;

/*
11. Container With Most Water
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

        Notice that you may not slant the container.

        Example 1:

        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49
        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 */
public class ContainerWithMostWater {

    /*
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int low = 0;
        int high = height.length - 1;

        while (low < high) {
            int area = Math.min(height[low], height[high]) * (high - low);
            maxArea = Math.max(maxArea, area);

            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }

        return maxArea;
    }

}
