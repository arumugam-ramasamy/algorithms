package com.evo.ib.strings;

public class StrSearch {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return -1 ;
        if (haystack.length() == 0) return -1 ;
        int [] lps = new int[needle.length()] ;
        computeLPS(needle, lps);
        int i = 0 ;
        int j = 0 ;
        int patlength = needle.length() ;
        int strlength = haystack.length() ;

        while (i < strlength) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                ++i ;
                ++j ;
            }

            if (j == patlength) {
                return (i-j) ;
            }

            else if (i < strlength && needle.charAt(j) != haystack.charAt(i)) {
                if (j!= 0) {
                    j = lps[j-1] ;
                }
                else
                    ++i ;

            }
        }
        return -1 ;
    }
    public void computeLPS (String pat, int[] lps) {

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
}
