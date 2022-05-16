package com.evo.ib.strings;

import com.evo.ib.arrays.ArrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class StringProblems {

    public static String reverseString (String str) {

        char [] arr = str.toCharArray() ;
        for (int i = 0 ; i < arr.length/2 ; i++) {
            char ch = arr[i] ;
            arr[i] = arr[arr.length-1-i] ;
            arr[arr.length-1-i] = ch ;
        }
        return Arrays.toString(arr);
    }

    public static boolean isAnagram1 (String s, String t){

        if (s.isEmpty() && t.isEmpty()) return true ;
        if (s.length() != t.length()) return false ;
        Map<Character, Integer> letters = new HashMap<>() ;
        for (int i = 0 ; i < s.length() ; i++) {
            if (letters.containsKey(s.charAt(i))) {
                letters.put(s.charAt(i), letters.get(s.charAt(i)) + 1) ;
            }
            else {
                letters.put(s.charAt(i), 1) ;
            }
        }

        for (int i = 0 ; i < t.length() ; i++) {
            if (letters.containsKey(t.charAt(i)) == false) {
                return false ;
            }
            else {
                int val = letters.get(t.charAt(i)) - 1;
                if (val == 0)
                    letters.remove(t.charAt(i)) ;
                else
                    letters.put(t.charAt(i), val);
            }
        }
        if (letters.size() == 0) return true ;
        return false ;

    }

    public boolean isAnagram2 (String s, String t){
        if (s.isEmpty() && t.isEmpty()) return true ;
        if (s.length() != t.length()) return false ;
        char [] s1 = s.toCharArray() ;
        char[] t1 = t.toCharArray() ;
        Arrays.sort(s1);
        Arrays.sort(t1);

        for (int i = 0 ; i < s.length() ; i++) {
            if (s1[i] != t1[i]) return false ;
        }
        return true ;
    }

    public boolean isAnagram3(String s, String t ) {
        if (s.isEmpty() && t.isEmpty()) return true ;
        if (s.length() != t.length()) return false ;
        int[] ch = new int[256] ;
        Arrays.fill(ch, 0) ;
        for (int i = 0 ; i < s.length() ; i++) {
            ch[(int)s.charAt(i)]++ ;
            ch[(int)t.charAt(i)]-- ;
        }
        for (int i = 0 ; i < 256 ; i++) {
            if (ch[i] != 0 ) return false ;
        }
        return true ;
    }

    public boolean isAnagramBest(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) return true ;
        if (s.length() != t.length()) return false ;

        if (s.length() > 256) return isAnagram3(s, t) ;
        return isAnagram2(s,t) ;
    }

    public boolean isPalindrome (String s) {
       if (s.isEmpty()) return true ;
       s = s.toLowerCase(Locale.ROOT) ;
        StringBuilder t = new StringBuilder() ;
        for (int i = 0 ; i < s.length() ; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                t.append(s.charAt(i)) ;
            }
        }
        String temp = t.toString() ;
        for (int i = 0 ; i < temp.length()/2 ; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length()-1-i)) return false ;
        }
        return true ;
    }

    public static int firstUniqueChar(String s) {
        if (s.isEmpty())  return -1 ;
        int [] chrCount = new int[256] ;
        for (int i = 0 ; i < s.length() ; i++) {
            chrCount[(int)s.charAt(i)]++ ;
        }
        for (int i = 0 ; i < s.length() ; i++) {
            if (chrCount[(int)s.charAt(i)] == 1) {
                return i ;
            }

        }
        return -1 ;
    }
}
