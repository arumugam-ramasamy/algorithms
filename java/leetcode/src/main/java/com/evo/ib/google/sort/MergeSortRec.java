package com.evo.ib.google.sort;

import java.util.Arrays;

public class MergeSortRec {

    public static void mergeSort (int [] arr, int left, int right) {

        int middle ;

       if (left < right) {
            middle = (left +right) / 2 ;
            mergeSort (arr, left, middle) ;
            mergeSort(arr, middle+1, right) ;
            mergeArrSort(arr, left, middle, right) ;
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

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        printArray(arr);
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);

    }

}
