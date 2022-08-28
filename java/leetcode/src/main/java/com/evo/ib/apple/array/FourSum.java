package com.evo.ib.apple.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum (int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>() ;
        if (nums == null || nums.length < 4) return res ;

        Arrays.sort(nums);
        int i = 0 ;
        while (i <= nums.length -3) {
            int j = i+1 ;
            while (j <= nums.length-2) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum =  ((long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right]);
                    if (sum == target) {
                        List<Integer> setarr = new ArrayList<>();
                        setarr.add(nums[i]);
                        setarr.add(nums[j]);
                        setarr.add(nums[left]);
                        setarr.add(nums[right]);
                        res.add(setarr);
                        int leftval = nums[left] ;
                        int rightval = nums[right] ;
                        if (((left + 1) < nums.length) && (nums[left] == leftval)) {
                            while (((left + 1) <  nums.length) && (nums[left] == leftval))
                                ++left;
                        }
                        if (((right - 1) >= 0) && (nums[right] == rightval)) {
                            while (((right - 1) >= 0) && (nums[right] == rightval))
                                --right;
                        }

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
                int jval = nums[j] ;
                if (((j + 1) < (nums.length)) && (nums[j] == jval)) {
                    while (((j + 1) < (nums.length)) && (nums[j] == jval)) ++j;
                }

            }
            int ival = nums[i];
            if (((i + 1) < (nums.length)) && (nums[i] == ival)) {
                while (((i + 1) < (nums.length)) && (nums[i] == ival)) ++i;
            }

        }
        return res ;
    }

    public static void main(String[] args) {
        //int [] arr = {1, 0, -1, -2, 0, 2} ;
        //int [] arr = {-2,-1,-1,1,1,2,2} ;
        int [] arr = {1000000000,1000000000,1000000000,1000000000} ;

        System.out.println (fourSum(arr, -294967296));
    }
}
