package com.evo.ib.strings;

import java.util.*;

public class StringHardProblems {

    public static String longestSubstringKDistinctChars (String str, int k) {
        if (k == 0) return null ;
        if (str == null || str.length() == 0) return null ;
        if (str.length()  < k)  return null ;
        str = str.toLowerCase(Locale.ROOT)  ;
        int count = 0 ;
        int max_start = 0 ;
        int max_size = 1 ;
        int countk = 1 ;
        int [] counts = new int[26] ;
        counts[str.charAt(0) - 'a']++ ;
        for (int i = 1 ; i < str.length() ; i++) {
            if (counts[str.charAt(i) - 'a'] == 0){
                countk++ ;
            }

        }
        return "" ;
    }

    public static Set<Integer> KMP (String haystack, String needle) {
        if (needle.length() == 0) return null ;
        if (haystack.length() == 0) return null ;
        int [] lps = new int[needle.length()] ;
        computeLPS(needle, lps);
        int i = 0 ;
        int j = 0 ;
        int patlength = needle.length() ;
        int strlength = haystack.length() ;
        Set <Integer> matches = new HashSet<>() ;

        while (i < strlength) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                ++i ;
                ++j ;
            }

            if (j == patlength) {
                    matches.add(i-j) ;
                    j = lps[j-1] ;
            }

            else if (i < strlength && needle.charAt(j) != haystack.charAt(i)) {
                    if (j!= 0) {
                        j = lps[j-1] ;
                    }
                    else
                        ++i ;

            }
        }
        return matches ;
    }

    public static void computeLPS (String pat, int[] lps) {

        int len = 0 ;
        int i = 1 ;
        int patlength = pat.length() ;
        lps[0] = 0 ;

        while (i < patlength) {
            if (pat.charAt(i) == pat.charAt(len)) {
               ++len ;
               lps[i] = len ;
               i++ ;
            }
            else {
                if (len != 0) {
                    len = lps[len-1] ;
                }
                else {
                    lps[i] = len ;
                    i++ ;
                }
            }
        }
    }

    public static void testKMP () {

        String s1 = "aa" ;
        String s2 = "aaaaabcdaaaaaaa";
        System.out.println(KMP(s2, s1) ) ;

    }

    public static double convertStrToInt(String str) {
        if (str == null || str.length() == 0) return 0 ;
        boolean negative = false ;
        boolean numBegan = false ;
        boolean decimalStart = false ;
       str = str.trim() ;
       int len = str.length() ;
       int i = 0 ;
        double beforeDecimal = 0.0 ;
        double afterDecimal = 0.0 ;
        double powunit = 1.0 ;
        double decunit = 0.1 ;
        if (str.charAt(i) == '-') negative = true ;
        // the following needs some more refinement
        str = str.replace(",", "") ;
        while (str.charAt(i) == ' ' || str.charAt(i) == 0) i++ ;

        while (i < len) {

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (decimalStart){
                    afterDecimal += (double) str.charAt(i) * decunit ;
                    decunit = decunit / 10.0 ;
                }
                else {
                    beforeDecimal += (double) str.charAt(i) * powunit ;
                }
            }
            else {
                if (str.charAt(i) == '.') {
                    if (decimalStart) {
                        System.err.println("Error in string double decimal");
                        return 0 ;
                    }
                    else decimalStart = true  ;
                }
                else {
                    System.err.println("non number characters are seen");
                    return 0 ;
                }
            }


        }

        beforeDecimal = beforeDecimal + afterDecimal ;
        if (negative) beforeDecimal *= -1.0 ;
        return beforeDecimal ;

    }

}
