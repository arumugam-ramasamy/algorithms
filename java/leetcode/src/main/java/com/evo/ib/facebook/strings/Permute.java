package com.evo.ib.facebook.strings;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null  || nums.length == 0) return null  ;
        List<List<Integer>> res = new ArrayList<List<Integer>>() ;
        permute(nums, 0, res) ;
        return res ;
    }

    public void permute (int[] nums, int index, List<List<Integer>> res){
        if (index == nums.length) {
            List<Integer> subRes = new ArrayList<>() ;
            for (int num : nums)
                subRes.add(num) ;
            res.add(subRes) ;
        }

        for (int i = index; i < nums.length ; i++) {
            swap (nums, index, i) ;
            permute(nums, index+1, res) ;
            swap (nums, index, i) ;
        }
    }

    public  void swap (int[] nums, int ind1, int ind2) {
        int temp = nums[ind1] ;
        nums[ind1] = nums[ind2] ;
        nums[ind2] = temp ;
    }
}
