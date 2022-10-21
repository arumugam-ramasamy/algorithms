package com.evo.ib.proofpoint;

import java.util.*;

public class EqualizeFrequency {
    public static  boolean equalFrequency(String word) {
        Map<Character, Integer> freqCount = new HashMap<>() ;
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i) ;
            if (freqCount.containsKey(ch)) {
                freqCount.put(ch, freqCount.get(ch)+1) ;
            }
            else {
                freqCount.put(ch, 1) ;
            }
        }
        if (freqCount.size() <= 1)  return true ;
        Map<Integer, Set<Character>> revFreq = new HashMap<>() ;
        for (Map.Entry <Character, Integer> kv : freqCount.entrySet()) {
            if (revFreq.containsKey(kv.getValue())) {
                Set<Character> letterList = revFreq.get(kv.getValue()) ;
                letterList.add(kv.getKey()) ;
            }
            else {
                Set<Character> letterList = new HashSet<>() ;
                letterList.add(kv.getKey()) ;
                revFreq.put(kv.getValue(), letterList) ;
            }
        }
        if (revFreq.size() > 2) return false ;
        if (revFreq.size() < 2) {
            for ( int key : revFreq.keySet() ) {
                if (key == 1) return true ;
                if (revFreq.get(key).size() == 1) return true ;
            }
            return false ;
        }
        int[] keys = new int[revFreq.size()] ;
        int ind = 0 ;
        for (Map.Entry <Integer, Set<Character>> kv : revFreq.entrySet()) {
            keys[ind++] = kv.getKey() ;
        }
        Arrays.sort(keys);
        if (keys[1] - keys[0] > 1) {
            if (keys[0] == 1 && revFreq.get(keys[0]).size() == 1)
                return true ;
            return false ;
        }
        if (revFreq.get(keys[1]).size() > 1) {
            if (keys[0] == 1 && revFreq.get(keys[0]).size() == 1)
                return true ;
            return false ;
        }
        return true ;
    }

    public static void main(String[] args) {
        System.out.println(equalFrequency(  "zz"));
    }
}
