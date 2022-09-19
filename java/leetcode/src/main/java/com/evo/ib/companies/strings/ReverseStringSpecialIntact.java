package com.evo.ib.companies.strings;

import java.util.Arrays;

public class ReverseStringSpecialIntact {

    public static String reverseString (String str) {
        if (str == null || str.length() <= 1) return str ;
        char [] charArr = str.toCharArray() ;
        int l = 0 ;
        int r = charArr.length-1 ;

        while ( l < r) {
            if (!Character.isAlphabetic(charArr[l])) {
                ++l ;
            }
            else if (!Character.isAlphabetic(charArr[r])) {
                --r ;
            }
            else {
                char ch = charArr[l] ;
                charArr[l] = charArr[r] ;
                charArr[r] = ch ;
                ++l ;
                --r ;
            }
        }

        return new String(charArr) ;
    }

    public static void main(String[] args) {
        String str = "a!!!b.c.d,e'f,ghi";
        System.out.println(reverseString(str));
    }
}
