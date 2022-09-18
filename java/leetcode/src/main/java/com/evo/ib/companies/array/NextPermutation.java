package com.evo.ib.companies.array;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int ind = -1 ;
        for (int i = nums.length-1 ; i> 0 ; --i) {
            if (nums[i] > nums[i-1]) {
                ind = i -1;
                break;
            }
        }
        if (ind == -1) {
            reverse(nums, 0, nums.length-1) ;
            return ;
        }

        int ind2 = nums.length-1 ;
        for (int i = nums.length-1 ; i >= ind+1 ; i--) {
            if (nums[i] > nums[ind]) {
                ind2 = i ;
                break ;
            }
        }
        swap (nums, ind, ind2) ;
        reverse(nums, ind+1, nums.length-1);
    }

    public static void reverse (int[] nums, int start, int end ) {
        while (start < end) {
            swap (nums, start, end) ;
            ++start ;
            --end ;
        }
    }

    public static void swap (int [] nums, int first, int second) {
        int temp = nums[first] ;
        nums[first] = nums[second] ;
        nums[second] = temp ;
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 4} ;
        for (int i = 0 ; i < 20 ; i++) {
            nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}
