package com.evo.ib.top.strings;

public class LongestPalnidrome {
    int resultStart ;
    int resultLength;
    public LongestPalnidrome () {
        resultStart = 0 ;
        resultLength = 1 ;
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null ;
        if (s.length() == 1) return s ;
        for (int i = 0 ; i < s.length()-1 ; i++) {
            expandRange (s, i, i) ;
            expandRange (s, i, i+1) ;
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    public void expandRange (String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start ;
            ++end ;
        }
        if (resultLength < (end - start -1)) {
            resultStart = start+1 ;
            resultLength = end - start -1 ;
        }
    }
}
