package com.evo.ib.number;

import java.util.*;


public class NumberProblems {

    public static int[] twoSums(int[] nums, int target) {
        int[] ans = null;
        if (nums == null || nums.length < 2) return null;
        Map<Integer, Integer> seenSoFar = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (seenSoFar.containsKey(other)) {
                ans = new int[2];
                ans[0] = seenSoFar.get(other);
                ans[1] = i;
                return ans;
            } else {
                seenSoFar.put(nums[i], i);
            }
        }

        return ans;
    }

    public static int[] plusOne(int[] digits) {

        int carry = 1 ;
        int i = digits.length-1 ;
        while (i>= 0) {
            int res = digits[i]  + carry ;
            if (res == 10) {
                digits[i] = 0;
                carry = 1;
            }
            else {
                digits[i] = res ;
                carry = 0 ;
            }
            i-- ;
            if (carry == 0) break ;
        }
        if (carry == 0) return digits ;
        int [] newdigits = new int[digits.length+1] ;
        newdigits[0] = 1 ;
        for (int j = 0 ; j < digits.length ; j++) {
            newdigits[j + 1] = digits[j];
        }
        return newdigits ;
    }

    public static void main(String[] args) {
        int [] arr = new int[1] ;
        arr[0] = 9 ;
        int [] ans = plusOne(arr) ;
    }
}


