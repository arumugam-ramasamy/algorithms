package com.evo.ib.zscaler.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LongestIncreasingSubSequence {
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0 ;
        int [] lis = new int[nums.length] ;
        int i, j, max= 0 ;
        for (i = 0 ; i < nums.length ; i++) {
            lis[i] = 1 ;
        }

        for ( i = 0 ; i < nums.length ; i++) {
            for (j = 0 ; j < i ; j++ ) {
                if (nums[i] > nums[j] && lis[i] < lis[j]+1)
                    lis[i] = lis[j]+1 ;
            }
        }

        for (i = 0 ; i < nums.length ; i++) {
            if (lis[i] > max)
                max = lis[i] ;
        }
        return max ;
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0 ;
        Set<Integer> sortedSet = new TreeSet<>() ;
        Arrays.stream(nums).forEach(num -> sortedSet.add(num));
        int[] lis = new int[sortedSet.size()] ;
        int k = 0 ;
       for (Integer num : sortedSet)
           lis[k++] = num ;
        int i, j ;
        int [][] dp = new int [k+1][nums.length+1] ;
        for (i = 0 ; i < k+1 ; i++)
            Arrays.stream(dp[i]).forEach(num -> num = -1);
        for (i = 0 ; i < k+1 ; i++){
            for (j = 0 ; j < nums.length+1 ; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0 ;
                }
                else if (lis[i-1] == nums[j-1]) {
                    dp[i][j] = 1+ dp[i-1][j-1] ;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) ;
                }
            }
        }
        return (dp[k][nums.length]) ;
    }
}
