package com.evo.ib.google;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int fd = -1 ;
        for (int i = nums.length-1 ; i > 0 ; i--) {
            if (nums[i] > nums[i-1]) {
                fd = i - 1 ;
                break ;
            }
        }
        if (fd == -1) {
            reverse(nums, 0, nums.length-1);
            return ;
        }

        int ind = nums.length-1 ;
        for (int i = nums.length-1 ; i >= fd+1 ; i--){
            if (nums[i] > nums[fd]) {
                   ind = i ;
                   break ;
            }
        }

        swap(nums, fd, ind) ;
        reverse(nums, fd+1, nums.length-1);

    }
    public static void swap (int[]arr, int i, int j) {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }

    public static void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            swap (arr, begin, end) ;
            begin++ ;
            end-- ;
        }
    }

    public static void main(String[] args) {
        int [] num = {1,2, 3, 4,5} ;
        for (int i = 0 ; i < 20 ; i++) {
            nextPermutation(num);
            System.out.println(Arrays.toString(num));
        }
    }
}
