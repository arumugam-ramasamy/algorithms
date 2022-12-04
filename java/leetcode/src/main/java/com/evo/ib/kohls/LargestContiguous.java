package com.evo.ib.kohls;

public class LargestContiguous {

    public static int largetContiguous (int [] nums) {
        int maxSoFar = Integer.MIN_VALUE ;
        int maxEnding = 0 ;

        for (int i = 0 ; i < nums.length ; i++) {
            maxEnding += nums[i] ;
            if (maxEnding > maxSoFar) {
                maxSoFar = maxEnding ;
            }
            if (maxEnding < 0)
                maxEnding = 0 ;
        }
        return  maxSoFar ;
    }
}
