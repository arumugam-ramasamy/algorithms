package com.evo.ib.top.array;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>() ;

        if (nums == null || nums.length < k) {
            System.err.println("array size is less than k ");
            return -1;
        }

        for (int i = 0 ; i < k ; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k ; i < nums.length ; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.add(nums[i]) ;
                minHeap.poll() ;
            }



        }
        return minHeap.peek() ;
    }
}
