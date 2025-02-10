package com.pattern.TopKElements;


import java.util.*;

/*
373. Find K Pairs with Smallest Sums
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
Define a pair (u, v) which consists of one element from the first array and one element from the second array.
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence:
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence:
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[2,3]

 */
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k,Comparator.comparingInt(a -> a[0] + a[1]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> result = new ArrayList<>();

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            result.add(List.of(current[0], current[1]));

            if (current[2] < nums2.length - 1) {
                minHeap.offer(new int[]{current[0], nums2[current[2] + 1], current[2] + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums obj = new FindKPairsWithSmallestSums();
        System.out.println(obj.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 4));
    }
}
