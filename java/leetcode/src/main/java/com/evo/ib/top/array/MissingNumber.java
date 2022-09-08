package com.evo.ib.top.array;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int len = nums.length ;
        int total = len * (len + 1) / 2 ;
        int sum = 0 ;
        for (int i = 0 ; i < nums.length ; i++) sum+= nums[i] ;
        return (total - sum) ;
    }

    // Did this for Kabir
    public static int missingNumberSet(int[] nums) {

        Set<Integer> numSet = new HashSet<>() ;
        int low = Integer.MAX_VALUE ;
        int high = Integer.MIN_VALUE ;
        for (int i = 0 ; i < nums.length ;i++) {
            if (low > nums[i]) low = nums[i] ;
            if (high < nums[i]) high = nums[i] ;
            numSet.add(nums[i]) ;
        }

        int begin = low ;
        while (numSet.contains(begin)) ++begin;
        if (begin > high) {
            System.out.print("no number is missing");
            return -1 ;
        }
        else
        System.out.println ("missing number is " + begin) ;
        return begin ;
    }

    public static void main(String[] args) {
        int [] arr =  { 8,7, 5, 6, 4, 3, 2 };
        System.out.println(missingNumberSet(arr));
    }
}
