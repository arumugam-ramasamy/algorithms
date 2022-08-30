package com.evo.ib.apple.string;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>() ;
        if (strs == null) return list ;
        Map<String, List<String>> res = new HashMap<>() ;
        for (String str : strs) {
            char [] charsStr = str.toCharArray() ;
            Arrays.sort(charsStr);
            String mapStr = String.valueOf(charsStr) ;
            if (res.containsKey(mapStr)) {
                List<String> anagramList = res.get(mapStr) ;
                anagramList.add(str) ;
                res.put(mapStr, anagramList) ;
            }
            else {
                List<String> anagramList = new ArrayList<>() ;
                anagramList.add(str) ;
                res.put(mapStr, anagramList) ;
            }
        }
        for (Map.Entry<String, List<String>> keyval : res.entrySet()) {
            list.add(keyval.getValue()) ;
        }
        return  list ;
    }

    public static void main(String[] args) {
        String [] arr = {"eat","tea","tan","ate","nat","bat"} ;
        System.out.println (groupAnagrams(arr)) ;
    }
}
