package com.evo.ib.top.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null ;
        Map<Integer, Integer> numsSeen = new HashMap<>() ;
        for (int i = 0 ; i < nums.length ; i++) {
            if (numsSeen.containsKey(target - nums[i])) {
                int [] res = new int[2] ;
                res[0] = numsSeen.get(target - nums[i]) ;
                res[1] = i ;
                return  res ;
            }
            else {
                numsSeen.put(nums[i], i) ;
            }
        }
        return null ;
    }
}
