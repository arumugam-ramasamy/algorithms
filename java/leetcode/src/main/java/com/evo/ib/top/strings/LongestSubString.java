package com.evo.ib.top.strings;

import java.util.Arrays;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
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
}
