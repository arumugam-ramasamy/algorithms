package com.evo.ib.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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

    public static int longestBestUniwueChar(String str) {
        int res = 0 ;
        int [] lastIndex = new int[256] ;
        Arrays.fill(lastIndex, -1);
        int len = str.length() ;
        int i = 0 ;
        for (int j = 0 ; j < len ; j++) {
            i = Math.max(i, lastIndex[str.charAt(j)]+1) ;
            res = Math.max(res, j-i+1) ;
            lastIndex[str.charAt(j)] = j ;
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

}
