package com.evo.ib.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static boolean wordPattern (String words, String pattern) {
        if (words == null && pattern == null) return true ;
        if (words.length() == 0 && pattern.length() == 0) return true ;
        if (words == null || words.length() == 0) return false ;
        if (pattern == null || pattern.length() == 0) return false ;
        String[] pats = pattern.split("") ;
        String[] word = words.split(" ") ;
        if (word.length != pats.length) return false ;
        Map <String, String> patword = new HashMap<>() ;
        for (int i = 0, j = 0 ; i < pats.length ; i++, j++) {
           if (patword.containsKey(pats[i])) {
               if (word[j].equals(patword.get(pats[i])) == false) {
                   return false ;
               }
           }
           else {
               patword.put(pats[i], word[j]) ;
           }
        }
        return true ;
    }

    public static Set<String> wordPattern2(String words, String pattern) {
        if (words == null && pattern == null) return null ;
        if (words.length() == 0 && pattern.length() == 0) return null ;
        if (words == null || words.length() == 0) return null ;
        if (pattern == null || pattern.length() == 0) return null ;
        Set<String> res = new HashSet<>() ;
        Map <Character, Integer> patmap = new HashMap<>() ;
        int i = 0 ;
        for (Character ch : pattern.toCharArray()) {
            if (patmap.containsKey(ch) == false) {
                patmap.put(ch, i) ;
                i++ ;
            }
        }
        String [] word = words.split(" ") ;
        for (String each : word) {
            if (each.length() != pattern.length()) continue ;

        }
        return res ;
    }

    public static void main(String[] args) {
        String pattern = "abba" ;
        String words = "cat dog dog cat" ;
        String newws = "cat dog dog lion" ;
        System.out.println(wordPattern(words, pattern));
        System.out.println(wordPattern(newws, pattern));
    }
}
