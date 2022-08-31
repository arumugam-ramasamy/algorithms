package com.evo.ib.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1 ;
        if (s.length() == 1) return 0 ;
        Map<Character, Integer> charFreq = new HashMap<>() ;
        for (int i = 0 ; i < s.length() ; i++) {
            if (charFreq.containsKey(s.charAt(i))) {
                charFreq.put(s.charAt(i), charFreq.get(s.charAt(i)) + 1) ;
            }
            else {
                charFreq.put(s.charAt(i), 1) ;
            }
        }

        for (int i = 0 ; i < s.length() ; i++) {
            if (charFreq.get(s.charAt(i)) == 1)
                return i ;
        }
        return -1 ;
    }
}
