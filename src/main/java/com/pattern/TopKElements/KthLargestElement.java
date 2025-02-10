package com.pattern.TopKElements;

import java.util.PriorityQueue;

/*
215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
