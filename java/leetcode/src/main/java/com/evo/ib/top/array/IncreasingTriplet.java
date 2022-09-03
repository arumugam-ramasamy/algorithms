package com.evo.ib.top.array;

public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < minOne) {
                minOne = num;
            }
            if (num > minOne) {
                minTwo = Math.min(num, minTwo);
            }
            if (num > minTwo) {
                return true;
            }
        }
        return false;
    }
}
