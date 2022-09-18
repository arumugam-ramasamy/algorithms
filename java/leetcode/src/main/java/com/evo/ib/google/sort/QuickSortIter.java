package com.evo.ib.google.sort;

import java.util.Stack;

public class QuickSortIter {
    public static void swap (int[] arr, int i, int j) {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }

    public static int []  iterativeQuickSort (int[] arr) {
        Stack<Pair> stack = new Stack<>() ;
        Pair pair = new Pair(0, arr.length-1 ) ;
        stack.push(pair) ;

        while (!stack.isEmpty()) {
            pair = stack.peek() ;
            stack.pop() ;
            int pivot = partition(arr, pair.getLow(), pair.getHigh()) ;

            if (pivot -1 > pair.getLow()) stack.push(new Pair(pair.getLow(), pivot-1)) ;
            if (pivot +1  < pair.getHigh()) stack.push(new Pair(pivot+1, pair.getHigh())) ;
        }
        return  arr ;
    }

    public static int partition (int [] arr, int low, int high) {
        int pivot = arr[high] ;
        int pindex = low ;
        int i ;
        for (i = low ; i < high ; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pindex) ;
                pindex++ ;
            }
        }
        swap (arr, pindex, high) ;
        return pindex ;
    }

    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 , 21, 20, 31, 41,19, 24, 25};

        System.out.println("Google Given Array");
        printArray(arr);

        iterativeQuickSort(arr);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
