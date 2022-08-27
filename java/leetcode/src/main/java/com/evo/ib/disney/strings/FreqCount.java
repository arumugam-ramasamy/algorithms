package com.evo.ib.disney.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FreqCount {
    public static Map<String, Integer> freqCount(String [] arr) {
        if (arr == null || arr.length == 0) return  null ;
        Map <String, Integer> counts = new HashMap<>() ;
        Set<String> maxKey = new HashSet<>();
        int maxVal = Integer.MIN_VALUE ;
        for (int i = 0 ; i < arr.length ; i++) {
            String str = cleanString(arr[i]) ;
            if (counts.containsKey(str)) {
                counts.put(str, counts.get(str) + 1) ;
            }
            else {
                counts.put(str, 1) ;
            }
            if (maxVal == counts.get(str)) {
                maxKey.add(str) ;
                continue ;
            }
            if (maxVal < counts.get(str)){
                maxVal = counts.get(str) ;
                maxKey.clear();
                maxKey.add(str) ;
            }

        }
        System.out.println (maxKey.toString() + " Max occurrences items") ;
        return counts ;
    }

    public static String cleanString(String str) {
        if (str ==  null || str.length() == 0) return str ;
        StringBuilder sb = new StringBuilder() ;
        int begin = 0 ;
        int end = str.length() -1 ;
        while (begin < str.length() && Character.isSpace(str.charAt(begin))) begin++;
        while (end >= 0 && Character.isSpaceChar(str.charAt(end))) end-- ;
        for (int i = begin ; i <= end ; i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                if (Character.isAlphabetic(str.charAt(i))) {
                    sb.append(Character.toLowerCase(str.charAt(i))) ;
                }
                else
                    sb.append(str.charAt(i));
            }
        }
        return  sb.toString() ;
    }

    public static void printOutput (Map <String, Integer> out) {
        if (out == null || out.size() == 0) {
            System.out.println ("Input has zero strings") ;
            return  ;
        }
        System.out.println ("The size of the result is " + out.size()) ;
        for (Map.Entry<String, Integer> keyval : out.entrySet()) {
            System.out.println (" Key = " + keyval.getKey() + ", value = " + keyval.getValue()) ;
        }
    }

    public static void main(String[] args) {
        String [] arr = {"apple", "! Apple #@", "orange123", "banana", "     banana"} ;
        Map<String, Integer> res = freqCount(arr) ;
        printOutput(res);

    }
}
