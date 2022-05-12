package com.evo.ib.number;

import com.evo.ib.arrays.ArrayProblems;

import java.lang.reflect.Array;
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

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = null ;
        if (nums == null) return result ;
        if (nums.length < 3) return result;
        result = new ArrayList<>() ;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start;
            int end;
            if (i == 0 || nums[i] > nums[i - 1]) {
                int negate = -nums[i];
                start = i + 1;
                end = nums.length - 1;
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (negate == sum) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[start]);
                        res.add(nums[end]);
                        result.add(res);

                        start++;
                        end--;

                        //avoid duplicate solutions
                        while (start < end && nums[end] == nums[end + 1])
                            end--;
                        while (start < end && nums[start] == nums[start - 1])
                            start++;

                    } else if (nums[start] + nums[end] < negate) {
                        start++;
                    } else {
                        end--;
                    }
                }

            }
        }
        return result;
    }
}

