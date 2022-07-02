package com.evo.ib.google;

public class ArrayProblems {

    public static int [] moveAllZerosLeft (int [] arr) {
        if (arr == null) return null ;

       int totalelem = arr.length ;
       int count = totalelem - 1 ;

       for (int i = totalelem -1 ; i >= 0 ; i-- ) {
           if (arr[i] != 0) {
               arr[count--] = arr[i] ;
           }
       }
       while (count >= 0) arr[count--] = 0 ;

        return arr ;
    }

    public static int [] moveAllZerosRight (int [] arr) {
        if (arr == null) return null ;

        int totalelem = arr.length ;
        int count = 0 ;

        for (int i = 0; i < totalelem; i++ ) {
            if (arr[i] != 0) {
                arr[count++] = arr[i] ;
            }
        }
        while (count < totalelem) arr[count++] = 0 ;

        return arr ;
    }

    public static void printarr (int [] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        printarr(arr);
        moveAllZerosLeft(arr) ;
        printarr(arr);
        int newarr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        printarr(newarr);
        moveAllZerosRight(newarr) ;
        printarr(newarr);
    }
}
