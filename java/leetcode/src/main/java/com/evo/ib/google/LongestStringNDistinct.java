package com.evo.ib.google;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LongestStringNDistinct {

    public static String nDistictChar(String str, int k) {
        Map<Character, Integer> distictCharCount = new HashMap<>() ;
        str = str.toLowerCase(Locale.ROOT) ;
        int curr_start = 0 ;
        int curr_end = 0 ;
        int max_curr_atart = curr_start ;
        int max_length = 1 ;
        distictCharCount.put(str.charAt(0), 1) ;
        for (int i = 1 ; i < str.length() ; i++) {
            if (distictCharCount.containsKey(str.charAt(i))) {
                distictCharCount.put(str.charAt(i), distictCharCount.get(str.charAt()) + 1) ;
                curr_end++ ;
            }
            while (distictCharCount.size() > k) {
                int val =  distictCharCount.get(str.charAt(curr_start)) ;
                val = val - 1 ;
                if (val == 0)
                    distictCharCount.remove()
            }
        }
    }
}
