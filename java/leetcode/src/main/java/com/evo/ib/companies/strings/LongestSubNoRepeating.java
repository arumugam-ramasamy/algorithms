package com.evo.ib.companies.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubNoRepeating {

    public static int longestSubString(String s) {
        int res = 0 ;
        int [] lastindex = new int[256] ;
        Arrays.fill(lastindex, -1);
        int len = s.length() ;
        int i = 0 ;
        for (int j = 0 ; j < len ; j++) {
            i = Math.max(i, lastindex[s.charAt(j)]+1) ;
            res = Math.max (res, j-i+1) ;
            lastindex[s.charAt(j)] = j;
        }
        return res ;
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)return 0 ;
        int res = 0 ;
        Map<Character, Integer> lastIndex = new HashMap<>() ;
        int i = 0 ;
        for (int j = 0 ; j < s.length() ; j++) {
            if (lastIndex.containsKey(s.charAt(j))) {
                int k = lastIndex.get(s.charAt(j)) + 1 ;
                if (k > i) i = k ;
                lastIndex.put(s.charAt(j), j) ;
            }
            else {
                lastIndex.put(s.charAt(j), j) ;
            }
            res = Math.max(res, j-i+1) ;
        }
        return  res ;
    }

    public static void main(String[] args) {
        String s = "abba" ;
        System.out.println(lengthOfLongestSubstring(s));
    }
}
