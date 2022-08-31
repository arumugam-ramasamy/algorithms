package com.evo.ib.arrays;

public class Single {
    public static int singleNumber(int[] nums) {
        int uniq = 0 ;
        for (int num : nums) {
            uniq ^= num ;
        }
        return uniq ;
    }

    public static void main(String[] args) {
        int [] arr = {2, 2, 7,7,9, 8, 9} ;
        System.out.println (singleNumber(arr)) ;
    }
}
