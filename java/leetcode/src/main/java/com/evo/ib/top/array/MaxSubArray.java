package com.evo.ib.top.array;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int max_so_far = nums[0], max_ending_here = 0;

        for (int i = 0; i < nums.length; i++)
        {
            max_ending_here = max_ending_here + nums[i];
            if (max_so_far < nums[i])
                max_so_far = nums[i] ;
            if (max_ending_here < 0)
                max_ending_here = 0;

        /* Do not compare for all
           elements. Compare only
           when max_ending_here > 0 */
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1} ;
        System.out.println(maxSubArray(arr));
    }
}
