package com.smic.practice.strings;

/**
 * Created by PranavsMac on 9/28/20.
 */
public class Reverse {

    public static String reverseString (String str){

        if (str == null || str.length() <= 1) return str ;

        StringBuilder sb = new StringBuilder() ;

        int pos = str.length() -1 ;

        while (pos >= 0) sb.append(str.charAt(pos--)) ;
        return sb.toString() ;

    }

    public static void main(String[] args) {

        System.out.println (reverseString("hello there"));
    }
}
