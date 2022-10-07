package com.evo.ib.zscaler.arrays;

public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0 ;
        int [] lis = new int[nums.length] ;
        int i, j, max= 0 ;
        for (i = 0 ; i < nums.length ; i++) {
            lis[i] = 1 ;
        }

        for ( i = 0 ; i < nums.length ; i++) {
            for (j = 0 ; j < i ; j++ ) {
                if (nums[i] > nums[j] && lis[i] < lis[j]+1)
                    lis[i] = lis[j]+1 ;
            }
        }

        for (i = 0 ; i < nums.length ; i++) {
            if (lis[i] > max)
                max = lis[i] ;
        }
        return max ;
    }
}
