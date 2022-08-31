package com.evo.ib.arrays;

import java.util.Arrays;

public class MoveZerosRight {
    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length <= 1) return ;
        int zeroposition = 0 ;
        int nonzeroposition = 0 ;
        while (nonzeroposition < nums.length) {
            while (nonzeroposition < nums.length  && nums[nonzeroposition] == 0){
                ++nonzeroposition ;
            }
            if (nonzeroposition == nums.length) break ;
            nums[zeroposition] = nums[nonzeroposition] ;
            ++zeroposition ;
            ++nonzeroposition ;
        }
        for (int i = zeroposition ; i < nums.length ; i++) {
            nums[i] = 0 ;
        }
        return ;
    }

    public static void main(String[] args) {
        int [] arr = { 2, 0, 0, 1, 0, 0, 3} ;
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
