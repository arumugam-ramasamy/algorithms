package com.evo.ib.strings;

import java.util.Arrays;
import java.util.Locale;

public class StringProblems {

    public static String reverseString (String str) {

        char [] arr = str.toCharArray() ;
        for (int i = 0 ; i < arr.length/2 ; i++) {
            char ch = arr[i] ;
            arr[i] = arr[arr.length-1-i] ;
            arr[arr.length-1-i] = ch ;
        }
        return Arrays.toString(arr);
    }
}
