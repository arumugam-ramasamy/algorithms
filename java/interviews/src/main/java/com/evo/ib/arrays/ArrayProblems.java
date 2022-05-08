package com.evo.ib.arrays;

import java.util.Iterator;
import java.util.List;

public class ArrayProblems {

    public static void removeDuplicates (List<Integer> arr) {

        int i = 1, j = 0;

        while (i < arr.size()) {
            while (i < arr.size() && arr.get(i) == arr.get(j)) {
                i++;
            }
            if (i == arr.size()) break;
            j++;
            if (i != j)
                arr.set(j, arr.get(i));
            i++;

        }
        j++;
        arr.set(j, arr.get(i-1));
        Iterator<Integer> itr = arr.listIterator() ;
        int k = 0 ;
        while (k < j) {itr.next() ; k++  ;}
        while (itr.hasNext()) {itr.remove(); itr.next();}
    }

    private static Object resizeArray (Object oldArray, int newSize) {
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
        int preserveLength = Math.min(oldSize, newSize);
        if (preserveLength > 0)
            System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
        return newArray;
    }

    public static int removeDuplicatesArr (int[] arr) {

        int i = 1, j = 0;
        if (arr == null) return 0 ;
        if (arr.length <= 1) return arr.length   ;
        while (i < arr.length) {
            while (i < arr.length && arr[i] == arr[j]) {
                i++;
            }
            if (i == arr.length) break;
            j++;
            if (i != j)
                arr[j] = arr[i];
            i++;

        }
        j++;
        System.out.println(i + " , " + j);
        if (i != j)
            arr[j] = arr[i-1] ;
        if (j < (arr.length))
            arr = (int[]) resizeArray(arr, j) ;
        ArrayProblems.printpureAr(arr);
        return j ;
    }

    public static void printpureAr (int[] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + ",") ;
        }
        System.out.println("end");
    }

    public static void printArr (List<Integer> arr) {
        for (int i = 0 ; i < arr.size() ; i++) {
            System.out.print (arr.get(i)+ ",")  ;
        }
        System.out.println("end");
    }

    public static void  rotateArr(int[] arr, int steps) {
        if (arr == null) return  ;
        if (steps > arr.length) steps = steps % arr.length ;
        if (arr.length <= 1) return ;
        int a = arr.length - steps ;
        reverseArr(arr, 0, a-1);
        reverseArr(arr, a, arr.length-1);
        reverseArr(arr, 0, arr.length-1);
        printpureAr(arr);

    }

    public static void reverseArr (int[] arr, int left, int right ) {
        if (arr == null) return  ;
        if (arr.length <= 1) return ;
        while (left < right)
        {
            int temp = arr[left] ;
            arr[left] = arr[right] ;
            arr[right] = temp ;
            left++ ;
            right-- ;
        }
    }
}
