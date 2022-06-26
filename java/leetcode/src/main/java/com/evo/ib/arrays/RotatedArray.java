package com.evo.ib.arrays;

public class RotatedArray {

    public static void rotateArray (int [] arr, int k) {

        revArray(arr, 0, k) ;
        printArray(arr);
        revArray(arr, k+1, arr.length-1) ;
        printArray(arr);
        revArray(arr, 0, arr.length-1) ;

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

        int [] arr = {1,2,3,4,5,6,7} ;
        printArray(arr);
        rotateArray(arr, 3);
        printArray(arr);
    }
}
