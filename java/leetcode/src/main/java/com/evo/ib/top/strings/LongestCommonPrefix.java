package com.evo.ib.top.strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return null ;
        int minLen = Integer.MAX_VALUE ;
        for (int i = 0 ; i < strs.length ;i++) {
            if (minLen > strs[i].length())
                minLen = strs[i].length() ;
        }
        char prev = ' ' ;
        for (int i = 0 ; i < minLen ; i++) {
            for (int j = 0 ; j < strs.length ; j++) {
                if (j == 0 ) {
                    prev = strs[j].charAt(i) ;
                    continue ;
                }
                if (strs[j].charAt(i) != prev)
                    return strs[j].substring(0, i) ;
            }
        }
        return strs[0].substring(0, minLen) ;
    }
}
