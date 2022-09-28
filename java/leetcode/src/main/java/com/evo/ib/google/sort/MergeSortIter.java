package com.evo.ib.google.sort;

import java.util.Arrays;

public class MergeSortIter {

    public static void mergeIterSort (int [] arr) {

        int n = arr.length ;

        int curr_size ;
        int left_start ;

        for (curr_size = 1 ; curr_size < n-1 ; curr_size = 2*curr_size) {
            for (left_start = 0 ; left_start < n-1 ; left_start += 2*curr_size) {
                int mid = Math.min(left_start+curr_size-1, n-1) ;
                int right = Math.min(left_start+2*curr_size -1, n-1) ;
                mergeArrSort(arr, left_start, mid, right);
            }
        }

    }

    public static void mergeArrSort(int [] arr, int l, int m, int r) {

        int [] leftArr = Arrays.copyOfRange(arr, l, m+1) ;
        int [] rightArr = Arrays.copyOfRange(arr, m+1, r+1) ;
        int i = 0 ;
        int j = 0 ;
        int k = l ;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++] ;
            }
            else {
                arr[k++] = rightArr[j++] ;
            }
        }

        while (i < leftArr.length) {
            arr[k++] = leftArr[i++] ;
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++] ;
        }
    }
    /* A utility function to print array of size n */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 , 21, 20, 31, 41,19, 24, 25};

        System.out.println("Google Given Array");
        printArray(arr);

        mergeIterSort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
