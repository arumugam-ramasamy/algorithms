package com.evo.ib.number;

import com.evo.ib.arrays.IntersectionI;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0 ;
        if (nums.length == 1) return 1 ;
        Set<Integer> numsSet = new HashSet<>() ;
        for (int i = 0 ; i < nums.length ; i++) {
            numsSet.add(nums[i]) ;
        }
        int max = 1 ;
        for (int num : nums) {
           int left = num - 1;
           int right = num + 1 ;
           int curmax = 1 ;
           if (numsSet.contains(num)) {
               numsSet.remove(num);
               while (numsSet.contains(left)) {
                   curmax++;
                   numsSet.remove(left);
                   left--;
               }
               while (numsSet.contains(right)) {
                   curmax++;
                   numsSet.remove(right) ;
                   right++;
               }
           }
            max = Math.max(max, curmax) ;
        }
        return max ;
    }
}
