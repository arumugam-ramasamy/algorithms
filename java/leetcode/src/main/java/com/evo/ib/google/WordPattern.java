package com.evo.ib.google;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static boolean wordPattern (String words, String pattern) {

        String[] pats = pattern.split("") ;
        String[] word = words.split(" ") ;
        Map <String, String> patword = new HashMap<>() ;
        for (int i = 0, j = 0 ; i < word.length ; i++) {
           // if (patword.containsKey())
        }
        return true ;
    }
}
