package com.evo.ib.usbank.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {

    public static List <List<Integer>> tripletSum (int [] nums) {
        List<List<Integer>> threeSum = new ArrayList<>() ;
        if (nums == null || nums.length < 3) return  threeSum ;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length-2 ; i++) {
            int start = i + 1 ;
            int end = nums.length -1 ;
            if (i == 0 || nums[i] > nums[i-1]) {
                int negate  = -nums[i] ;
                while (start < end ) {
                    int sum = nums[start] + nums[end] ;
                    if (sum == negate) {
                        List<Integer> res = new ArrayList<>() ;
                        res.add(nums[i]) ;
                        res.add(nums[start]) ;
                        res.add(nums[end]) ;
                        threeSum.add(res) ;
                        ++start ;
                        --end ;
                        while (start < end && nums[start] == nums[start-1]) ++start ;
                        while (start < end && nums[end] == nums[end+1]) --end ;
                    }
                    else if (sum < negate) {
                        ++start ;
                    }
                    else --end ;
                }
            }
        }
        return  threeSum ;

    }

    public static void main(String[] args) {
        int [] arr = {-1, 0, 0,0} ;

        System.out.println (tripletSum(arr) ) ;
    }
}
