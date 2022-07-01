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


}

