package com.evo.ib.number;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1 ;
        Set<Integer> uniq = new HashSet<>() ;
        for (int i = 0 ; i < nums.length ; i++) {
            if (uniq.contains(nums[i]))
                return nums[i] ;
            uniq.add(nums[i]) ;
        }
        return -1 ;
    }
}
