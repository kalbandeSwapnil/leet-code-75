package com.easy;
/*


1207. Unique Number of Occurrences

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.



Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 */
public class UniqueNumberOfOccurrences {


    public boolean uniqueOccurrences(int[] arr) {
        int[] visited = new int[2001];
        int[] amount = new int[1001];
        int nonUniqueOccurrences = 0;
        for (int num : arr) {
            int i = num + 1000;
            if (visited[i] > 0 && --amount[visited[i]] > 0) {
                --nonUniqueOccurrences;
            }
            if (++amount[++visited[i]] > 1) {
                ++nonUniqueOccurrences;
            }
        }

        return nonUniqueOccurrences == 0;
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurrences solution = new UniqueNumberOfOccurrences();


        int[] arr1 = {1, 2, 2, 1, 1, 3};
        System.out.println(solution.uniqueOccurrences(arr1)); // Output: true


        int[] arr2 = {1, 2};
        System.out.println(solution.uniqueOccurrences(arr2)); // Output: false

        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(solution.uniqueOccurrences(arr3)); // Output: true
    }
}
