package com.smic.practice.strings;

import java.util.HashMap;
import java.util.Map;

public class MaxChars {
    public static Character maxChars (String str){
        if (str == null || str.length() == 0) return null ;
        Map<Character, Integer> charCount = new HashMap<>() ;
        int curMax = 0 ;
        str = str.toLowerCase() ;
        Character curChar = null ;
        for (int i = 0 ; i < str.length() ; i++) {
            if (charCount.containsKey(str.charAt(i))) {
                charCount.put(str.charAt(i), charCount.get(str.charAt(i)) + 1) ;
            }
            else {
                charCount.put(str.charAt(i), 1) ;
            }
            if (curMax < charCount.get(str.charAt(i))) {
                curMax = charCount.get(str.charAt(i)) ;
                curChar = str.charAt(i) ;
            }
        }
        for (Map.Entry<Character, Integer> kv : charCount.entrySet()) {
            System.out.println(kv.getKey() + " = " + kv.getValue());
        }
        return  curChar ;
    }
}
