package com.evo.ib.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberMediumProblems {
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
