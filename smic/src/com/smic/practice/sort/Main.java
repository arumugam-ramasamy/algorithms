package com.smic.practice.sort;

import java.util.Random;

public class Main {
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        Random rand = new Random() ;
        int max = 50 ;
        int [] arr = new int[max] ;
        for (int i = 0 ; i <  max ; i++) {
            arr[i] = rand.nextInt(100);
        }
        printArray(arr);
        int n = arr.length;
/*
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
    */
     arr = QuickSortIter.iterativeQuickSort(arr)     ;

        System.out.println("sorted array");
        printArray(arr);
    }
}
