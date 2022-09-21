package com.evo.ib.apple.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeating {
    public static int longestSubStringWithoutRepeating(String str) {
        if (str == null || str.length() == 0) return 0 ;
        int [] inds = new int[256];
        Arrays.fill(inds, -1);
        int i = 0 ;
        int res = 0 ;
        for (int j = 0 ; j < str.length() ; j++){
            i = Math.max(i, inds[str.charAt(j)]+1) ;
            res = Math.max(res, j-i+1) ;
            inds[str.charAt(j)] = j ;
        }
        return res ;
    }

    /*public static String longestUnique (String str){
        if (str == null || str.length() == 0) return "" ;
        Map<Character, Integer> indexChar = new HashMap<>() ;
        int start = 0 ;
        int end = 0 ;
        for (int j = 0 ; j < str.length() ; j++) {
            if (indexChar.containsKey(str.charAt(j))) {
                start = j ;
                indexChar.put(str.charAt(j), j) ;
            }
            else {
                indexChar.put(str.charAt(j), j) ;
            }
        }
    }*/

    public static void main(String[] args) {
        String str = "AABCDEAF" ;
        System.out.println (longestSubStringWithoutRepeating(str));
    }
}
