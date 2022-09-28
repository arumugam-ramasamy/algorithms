package com.evo.ib.companies.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public static int [] twoSum (int [] nums, int target) {
        if (nums == null || nums.length < 2) return null ;
       // Set<Integer> uniqueNums = new HashSet<>() ;
        Map<Integer, Integer> uniqueNums = new HashMap<>() ;
        for (int i = 0 ; i < nums.length ; i++) {
            if (uniqueNums.containsKey(target - nums[i])) {
                int [] res = new int [2] ;
                res[0] = uniqueNums.get(target-nums[i]) ;
                res[1] = i ;
                return res ;
            }
            else {
                uniqueNums.put(nums[i], i) ;
            }
        }
        return null ;
    }
}
