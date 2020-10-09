package com.smic.practice.strings;

import java.util.*;
import java.lang.*;


/**
 * Created by PranavsMac on 9/26/20.
 */

// Java program to print all
// permutations using Johnson
// and Trotter algorithm.

public class Permutations {

    private final static boolean LEFT_TO_RIGHT = true;
    private final static boolean RIGHT_TO_LEFT = false;

    // Utility functions for
    // finding the position
    // of largest mobile
    // integer in a[].
    public static int searchArr(int a[], int n,
                                int mobile) {
        for (int i = 0; i < n; i++)

            if (a[i] == mobile)
                return i + 1;

        return 0;
    }

    // To carry out step 1
    // of the algorithm i.e.
    // to find the largest
    // mobile integer.
    public static int getMobile(int a[],
                                boolean dir[], int n) {
        int mobile_prev = 0, mobile = 0;

        for (int i = 0; i < n; i++) {
            // direction 0 represents
            // RIGHT TO LEFT.
            if (dir[a[i] - 1] == RIGHT_TO_LEFT &&
                    i != 0) {
                if (a[i] > a[i - 1] &&
                        a[i] > mobile_prev) {
                    mobile = a[i];
                    mobile_prev = mobile;
                }
            }

            // direction 1 represents
            // LEFT TO RIGHT.
            if (dir[a[i] - 1] == LEFT_TO_RIGHT && i != n - 1) {
                if (a[i] > a[i + 1] &&
                        a[i] > mobile_prev) {
                    mobile = a[i];
                    mobile_prev = mobile;
                }
            }
        }

        if (mobile == 0 && mobile_prev == 0)
            return 0;
        else
            return mobile;
    }

    // Prints a single
    // permutation
    public static int printOnePerm(int a[], boolean dir[],
                                   int n) {
        int mobile = getMobile(a, dir, n);
        int pos = searchArr(a, n, mobile);

        // swapping the elements
        // according to the
        // direction i.e. dir[].
        if (dir[a[pos - 1] - 1] == RIGHT_TO_LEFT) {
            int temp = a[pos - 1];
            a[pos - 1] = a[pos - 2];
            a[pos - 2] = temp;
        } else if (dir[a[pos - 1] - 1] == LEFT_TO_RIGHT) {
            int temp = a[pos];
            a[pos] = a[pos - 1];
            a[pos - 1] = temp;
        }

        // changing the directions
        // for elements greater
        // than largest mobile integer.
        for (int i = 0; i < n; i++) {
            if (a[i] > mobile) {
                if (dir[a[i] - 1] == LEFT_TO_RIGHT)
                    dir[a[i] - 1] = RIGHT_TO_LEFT;

                else if (dir[a[i] - 1] == RIGHT_TO_LEFT)
                    dir[a[i] - 1] = LEFT_TO_RIGHT;
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(a[i]);

        System.out.print(" ");

        return 0;
    }

    // To end the algorithm
    // for efficiency it ends
    // at the factorial of n
    // because number of
    // permutations possible
    // is just n!.
    public static int fact(int n) {
        int res = 1;

        for (int i = 1; i <= n; i++)
            res = res * i;
        return res;
    }

    // This function mainly
    // calls printOnePerm()
    // one by one to print
    // all permutations.
    public static void printPermutation(int n) {
        // To store current
        // permutation
        int[] a = new int[n];

        // To store current
        // directions
        boolean[] dir = new boolean[n];

        // storing the elements
        // from 1 to n and
        // printing first permutation.
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
            System.out.print(a[i]);
        }

        System.out.print(" ");

        // initially all directions
        // are set to RIGHT TO
        // LEFT i.e. 0.
        for (int i = 0; i < n; i++)
            dir[i] = RIGHT_TO_LEFT;

        // for generating permutations
        // in the order.
        for (int i = 1; i < fact(n); i++) {
            if (i % n == 0)
                System.out.println();
            printOnePerm(a, dir, n);
        }
    }

    public static void  permRecursive (String str, String strleft ) {

      if (str.length() == 0) {
          System.out.print(strleft + " ");
      }
        boolean [] chars = new boolean[256] ;
        for (int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i) ;

            String rest = str.substring(0, i) + str.substring(i+1) ;
            if (chars[ch]  == false)
               permRecursive(rest, ch + strleft);
            chars[ch] = true ;
        }

    }

    /*

          23 , 1  i = 0 ;
          3,  12  i = 0 (23)
          "", 123 i = 0 (3)
          1,  2 i = 3, 9

          "", 132

     */
    public static void pRec (String str, String strleft) {
        if (str.length() == 0 ) {
            System.out.print (strleft + " ") ;
        }

        boolean [] c = new boolean[256] ;
        for (int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i) ;
            String res = str.substring(0, i) + str.substring(i+1) ;
            if (c[ch] == false) {
                pRec (res, ch + strleft ) ;
            }
            c[ch] = true ;
        }
    }
    public static void pIter (String str, int n) {
        char [] c = str.toCharArray() ;
        Arrays.sort(c) ;
        while (true) {
            System.out.print(String.valueOf(c) + " ") ;
            int i = n - 1 ;
            while (c[i-1] >= c[i]) {
                if (--i == 0) return ;
            }
            int j = n-1 ;
            while (j > i && c[j] <= c[i-1]) {
                j--;
            }
            swap (c, i-1, j) ;
            reverse(c, i, n-1);
        }
    }

    public static  void permutationIter (String str, int n){

        char [] carray = str.toCharArray() ;
        Arrays.sort(carray);

        while (true) {
            System.out.print(String.valueOf(carray) + " ");
            int i = n -1 ;
            while (carray[i-1] >= carray[i]) {
                if (--i == 0)
                    return;
            }
            int j = n -1 ;
            while (j > i && carray[j] <= carray[i-1]){
                j-- ;
            }
            swap(carray, i-1, j);
            reverse(carray, i, n-1) ;
        }

    }
    private static String join(char[] a) {
        StringBuilder builder = new StringBuilder();
        builder.append(a);
        return builder.toString();
    }

    private static void reverse (char[] carr, int i, int j) {
        while (i < j) {
            swap(carr, i++, j--);
        }
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
