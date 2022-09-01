package com.evo.ib.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return null ;
        List<List<Integer>> res = new ArrayList<List<Integer>>() ;
        int total = (int) Math.pow(2.0, (double) nums.length)  ;
        for (int i = 0 ; i < total ; i++) {
            List<Integer> set  = new ArrayList<>() ;
            for (int j = 0 ; j < nums.length ; j++){
                if ((i & (1<<j))  > 0) {
                    set.add(nums[j]) ;
                }
            }
            res.add(set) ;
        }
        return  res ;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4} ;
        System.out.println (subsets(arr)) ;
    }
}
