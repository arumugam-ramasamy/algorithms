package com.smic.practice.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static boolean isAnagram (String str1, String str2) {
        if (str1 == null && str2 == null) return true ;
        if (str1 == null || str2 == null) return false ;
        str1 = str1.replace(" " , "") ;
        str2 = str2.replace(" ", "") ;
        str1= str1.toLowerCase() ;
        str2 = str2.toLowerCase() ;
        if (str1.length() != str2.length()) return false ;
        char [] arrayStr1 = str1.toCharArray() ;
        char [] arrayStr2 = str2.toCharArray() ;
        Arrays.sort(arrayStr1) ;
        Arrays.sort(arrayStr2);
        return Arrays.equals(arrayStr1, arrayStr2) ;

    }

    public static boolean isNewAnagram (String first, String second) {
        if (first == null && second == null) return true ;
        if (first == null || second == null) return false ;
        first = first.replace(" " , "") ;
        second = second.replace(" ", "") ;
        first = first.toLowerCase() ;
        second = second.toLowerCase() ;
        if (first.length() != second.length()) return false ;
        Map<Character, Integer> chlist = new HashMap<>() ;
        for (int i = 0 ; i < first.length() ; i++) {
            chlist.put(first.charAt(i), chlist.containsKey(first.charAt(i)) ?
                    chlist.get(first.charAt(i)) +1 : 1) ;
        }
        for (int i = 0 ; i < second.length() ; i++) {
            if (chlist.containsKey(second.charAt(i))) {
                int val = chlist.get(second.charAt(i)) ;
                val = val -1 ;
                if (val == 0)
                    chlist.remove(second.charAt(i)) ;
                else
                    chlist.put(second.charAt(i), val) ;
            }
            else
                return false ;
        }
        if (chlist.size() > 0)  return false ;
        return true ;
    }

    public static void main(String[] args) {
        System.out.println(isNewAnagram("Keep", "Peek"));
        System.out.println(Anagrams.isNewAnagram("Mother In Law", "Hitler Woman"));
    }
}
