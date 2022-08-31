package com.evo.ib.arrays;

public class RotatedArray {

    public static void rotateArray (int [] nums, int k) {
        if (nums == null || nums.length <= 1) return ;
        if (k == 0) return ;
        if (k > nums.length) k = k % nums.length;
        if (nums.length == 2 && k == 1) {
            int temp = nums[1] ;
            nums[1] = nums[0] ;
            nums[0] = temp ;
            return ;
        }

      /*  if (k%2 == 0){
            revArray(nums, 0, k-1) ;
            revArray(nums, k, nums.length-1) ;
        }
        else {
            revArray(nums, 0, k) ;
            revArray(nums, k+1, nums.length-1) ;
        }
*/
        revArray(nums, 0, k) ;
        revArray(nums, k+1, nums.length-1) ;
        revArray(nums, 0, nums.length-1) ;

    }

    public static void  printArray (int [] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print (arr[i] + " ") ;
        }
        System.out.println();
    }
    public static void revArray (int [] arr, int left, int right) {

        while (left < right ) {
            int temp = arr[left] ;
            arr[left] = arr[right] ;
            arr[right] = temp ;
            left++ ;
            right-- ;
        }
    }

    public static void  main (String [] args) {

        int [] arr = {1, 2, 3} ;
        printArray(arr);
        rotateArray(arr, 2);
        printArray(arr);
    }
}
