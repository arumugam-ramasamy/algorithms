package com.evo.ib.walmart.array;

import java.util.*;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) return  null ;
        int [] res = new int[nums.length - k+1] ;
        Deque<Integer> queue = new LinkedList<>() ;
        int i = 0 ;
        for (; i < k ; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()])
                queue.removeLast() ;
            queue.addLast(i);
        }
        for (; i < nums.length ; i++) {
            res[i-k] = nums[queue.peek() ];
            while (!queue.isEmpty() && queue.peek() <=(i-k)) {
                queue.removeFirst() ;
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        res[i-k] = nums[queue.peek() ];
        return res ;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || nums.length < k) return  null ;
        int [] res = new int[nums.length - k] ;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()) ;
        int i = 0 ;
        for (i = 0 ; i < k ; i++) {
            pq.add(nums[i]) ;
        }
        res[0] = pq.peek() ;
        pq.remove(nums[0]) ;

        for (; i < nums.length ; i++){
            pq.add(nums[i]) ;
            res[i -k+1] = pq.peek() ;
            pq.remove(nums[i-k+1]) ;
        }
        return res ;
    }
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length < k) return  null ;
        int [] res = new int[nums.length - k] ;
        res[0] = Integer.MIN_VALUE ;
        for (int i = 0 ; i < k ; i++) {
            res[0] = Math.max(nums[0], res[0]) ;
        }
        int maxSum = res[0] ;
        for (int i = 0 ; i < nums.length-k ; i++) {
           res[i+1] = Math.max(nums[i+k], res[i]) ;
        }
        return res ;
    }

    public static Integer maxSlidingWindow10 (int[] arr, int k) {
        if (arr == null || arr.length < k) return  null ;

        int windowSum = 0 ;
        for (int i = 0 ; i < k ; i++) windowSum += arr[i] ;
        int maxSum = windowSum ;
        for (int i = 0 ; i < arr.length -k  ; i++) {
            windowSum = windowSum - arr[i] + arr[i+k] ;
            maxSum = Math.max(maxSum, windowSum) ;
        }
        return maxSum ;
    }
}
