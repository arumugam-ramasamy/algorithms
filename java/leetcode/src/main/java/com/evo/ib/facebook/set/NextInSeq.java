package com.evo.ib.facebook.set;

public class NextInSeq {
    public void nextPermutation(int[] nums) {
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

    public void swap (int[]arr, int i, int j) {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }

    public void reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            swap (arr, begin, end) ;
            begin++ ;
            end-- ;
        }
    }
}
