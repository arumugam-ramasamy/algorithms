package com.evo.ib.number;

import java.util.HashSet;
import java.util.Set;

public class FirstMissing {
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1 ;
        Set<Integer> setEle = new HashSet<>() ;
        for (int i = 0 ; i < nums.length ; i++) {
            setEle.add(nums[i]) ;
        }
        int missing = 0 ;
        while (missing < nums.length){
            if (!setEle.contains(missing+1))
                return (missing+1) ;
            missing++ ;
        }
        return (missing+1);
    }

    public static void main(String[] args) {
        int [] arr = {1} ;
        System.out.println(firstMissingPositive(arr));
    }
}
