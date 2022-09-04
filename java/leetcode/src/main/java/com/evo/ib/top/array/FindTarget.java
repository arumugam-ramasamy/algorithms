package com.evo.ib.top.array;

import java.util.Arrays;

public class FindTarget {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2] ;
        res[0] = -1 ;
        res[1] = -1 ;

        if (nums == null ||  nums.length == 0) return res;
        int i = 0 ;
        int ind = - 1;
        int start = 0 ;
        int end = nums.length-1 ;
        while (start <= end ) {
            ind = start+ (end - start)/2 ;
            if (nums[ind] == target)
                break ;
            if (nums[ind] > target) {
                end = ind - 1;
                ind = -1;
            }
            else {
                start = ind + 1;
                ind = -1;
            }
        }

        if (ind == -1) {
            return res ;
        }
        start = ind ;
        end = ind ;
        while (start >= 0 && nums[start] == target) --start ;
        while (end < nums.length && nums[end] == target) ++end ;
        start = start+1 ;
        end = end - 1;
        res[0] = start ;
        res[1] = end ;
        return res ;
    }

    public static void main(String[] args) {
        int [] arr = {5,7,7,8,8,10} ;
        int target = 6 ;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
}
