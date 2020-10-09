package com.smic.practice.array;

import java.util.*;

public class ArrayProblems {

    public static int [] rearrange(int[] arr) {

        for (int i = 1 ; i < arr.length-1; i+=2) {

            if (arr[i-1] > arr[i]) {
                int temp =  arr[i-1] ;
                arr[i-1] = arr[i] ;
                arr[i] = temp ;
            }

            if (arr[i] < arr[i+1]) {
                int temp = arr[i] ;
                arr[i] = arr[i+1] ;
                arr[i+1] = temp ;
            }

        }
        return arr ;
    }

    public static int [] sortBinary (int [] arr) {
        if (arr == null || arr.length <= 1) return arr ;
        int k = 0 ;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == 0){
                arr[k++] = 0 ;
            }
        }
        while (k < arr.length) arr[k++] = 1;
        return arr ;
    }

    public static Map<Integer, String> zeroSubArr (int [] arr) {
        if (arr == null || arr.length == 0) return null ;
        Map<Integer, String> sumlist = new HashMap<>() ;
        int sum = 0 ;
        sumlist.put(0, "-1") ;
        for (int i = 0 ; i < arr.length ; i++) {
            sum += arr[i] ;
            if (sumlist.containsKey(sum)) {
                String val = sumlist.get(sum) ;
                sumlist.put(sum, val +"," + i) ;
            }
            else {
                sumlist.put(sum, ((Integer) i).toString()) ;
            }
        }
        return sumlist   ;
    }

    public static void longestSubArray (int [] arr, int Sum) {

        if (arr == null || arr.length <= 0 ) {
            System.out.println("No valid subarray element exits");
        }
        Map <Integer, Integer> ls = new HashMap<>( );
        int len = 0 ;
        int endIndex = -1 ;
        ls.put(0, -1) ;
        int sum = 0 ;
        for (int i = 0 ; i < arr.length ; i++) {
            sum += arr[i] ;
            ls.putIfAbsent(sum, i) ;
            if (ls.containsKey(sum -Sum) && len < (i - ls.get(sum-Sum))) {
                len = i - ls.get(sum-Sum) ;
                endIndex = i ;
            }
        }

        for (int i = endIndex - len +1 ; i <= endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
