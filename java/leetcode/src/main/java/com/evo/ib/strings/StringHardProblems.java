package com.evo.ib.strings;

import java.util.*;

public class StringHardProblems {

    public static int longestSubUniqueChars (String str) {

        int res = longestUniqueNChars(str);

        return res ;
    }

    public static boolean areDistinct (String str, int i, int j) {
        boolean [] visited  = new boolean[26] ;
        for (int k = i ; k <= j ; k++) {
            if (visited[str.charAt(k) - 'a'] == true) {
                return false ;
            }
            visited[str.charAt(k) - 'a'] = true ;
        }
        return true ;
    }

    public static int longestUniqueN2Chars (String str) {
        int len = str.length() ;
        int res = 0 ;
        for (int i = 0 ; i < len ; i++) {
            for (int j = i ; j < len ; j++) {
                if (areDistinct(str, i, j)) {
                    res = Math.max(res, j-i+1) ;
                }
            }
        }
        return res ;
    }

    public static int longestUniqueNChars (String str) {
        String test = "" ;

        if (str == null || str.length() == 0)   return 0 ;
        if (str.length() == 1) return 1 ;
        int res = 0 ;

        for (char c : str.toCharArray()) {
            if (test.contains(String.valueOf(c))) {
                test = test.substring(test.indexOf(c) + 1) ;
            }
            test = test + String.valueOf(c) ;
            res = Math.max(res, test.length()) ;
        }
        return res ;
    }

    public static int longestBestUniwueChar(String s) {
        int res = 0 ;
        int [] lastIndex = new int[256] ;
        Arrays.fill(lastIndex, -1);
        int len = s.length() ;
        int i = 0 ;
        for (int j = 0 ; j < len ; j++) {
            i = Math.max(i, lastIndex[s.charAt(j)]+1) ;
            res = Math.max(res, j-i+1) ;
            lastIndex[s.charAt(j)] = j ;
        }
        return res ;
    }

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

    public static Set<Integer> KMP (String str, String pat) {
        if (pat.length() == 0) return null ;
        if (str.length() == 0) return null ;
        int [] lps = new int[pat.length()] ;
        computeLPS(pat, lps);
        int i = 0 ;
        int j = 0 ;
        int patlength = pat.length() ;
        int strlength = str.length() ;
        Set <Integer> matches = new HashSet<>() ;

        while (i < strlength) {
            if (pat.charAt(j) == str.charAt(i)) {
                ++i ;
                ++j ;
            }

            if (j == patlength) {
                    matches.add(i-j) ;
                    j = lps[j-1] ;
            }

            else if (i < strlength && pat.charAt(j) != str.charAt(i)) {
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
