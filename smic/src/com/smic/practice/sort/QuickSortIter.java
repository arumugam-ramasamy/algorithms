package com.smic.practice.sort;

import sun.java2d.pipe.SpanIterator;

import java.util.Stack;

public class QuickSortIter {
    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }

    public static int partition (int[] arr, int low, int high) {

        int pivot = arr[high] ;

        int pindex = low ;
        int i  ;
        for (i = low ; i < high ; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pindex) ;
                pindex++ ;
            }
        }
        swap (arr, pindex,  high) ;
        return pindex ;
    }

    public static int [] iterativeQuickSort (int [] arr) {
        Stack<Pair> stack = new Stack<Pair>() ;
        int low = 0 ;
        int high = arr.length-1 ;

        Pair pair = new Pair(low, high) ;
        stack.push(pair) ;
        while (stack.isEmpty() == false) {

            low  = stack.peek().getLow() ;
            high = stack.peek().getHigh() ;
            stack.pop() ;
            int pivot = partition(arr, low, high) ;

            if (pivot -1 > low) stack.push(new Pair(low, pivot-1)) ;
            if (pivot +1 < high) stack.push(new Pair(pivot+1, high)) ;

        }
        return arr ;
    }
}
