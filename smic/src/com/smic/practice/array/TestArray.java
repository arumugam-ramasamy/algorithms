package com.smic.practice.array;

import java.util.Map;
import java.util.Random;

public class TestArray {

    public static void testBinaryArr () {
        int [] arr = {0, 1, 0, 1, 0, 1,0,0,1,1} ;
        printArr(arr);
        arr = ArrayProblems.sortBinary(arr) ;
        printArr(arr);
    }

    public static void printArr (int [] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ") ;
        }
        System.out.println();
    }

    public static void testLongestSubArray() {
        int[] A = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        ArrayProblems.longestSubArray(A, 0);
    }
    public static void testzeroSubArr() {
        int[] A = { 3,4, -7, 3, 1, 3, 1, -4, -2, -2 };
        Map<Integer, String> sumlist = ArrayProblems.zeroSubArr(A) ;
        for (Map.Entry<Integer, String>kv : sumlist.entrySet()) {
            String[] slist = kv.getValue().split(",") ;
            if (slist.length ==1 ) continue;
            int beg = Integer.parseInt(slist[0]) ;
            int end = -1 ;
            for (int i = 1 ; i < slist.length ; i++) {
                end = Integer.parseInt(slist[i]) ;
                for (int j = beg + 1 ; j <= end ; j++) {
                    if (j == beg+1)
                        System.out.print(A[j] ) ;
                    else
                        System.out.print("," + A[j] ) ;
                }
                System.out.println();
                beg = end ;
            }
        }
    }

    public static void testRearrange () {
        Random rand = new Random( );
        int [] arr = new int[21] ;
        for (int i = 0 ; i < arr.length ; i++)
            arr[i] = rand.nextInt(100) ;
        arr = ArrayProblems.rearrange(arr) ;
        for (int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i] + " ") ;
        System.out.println();
    }

}
