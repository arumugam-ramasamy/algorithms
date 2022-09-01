package com.evo.ib.arrays;

public class IncresingTriplets {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null | nums.length < 3) return false ;
        int count = 0 ;
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] > nums[i-1]) {
                count++ ;
                if (count == 2) return true ;
            }

        }
        return false ;
    }
}
