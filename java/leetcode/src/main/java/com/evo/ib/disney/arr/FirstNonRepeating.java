package com.evo.ib.disney.arr;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static Integer firstNonRepeatingInt (int[] arr) {
        if (arr == null || arr.length == 0) return null ;
        Map<Integer, Integer> freqCount = new HashMap<>() ;
        for (int i = 0 ; i < arr.length ; i++) {
            if (freqCount.containsKey(arr[i])) {
                freqCount.put(arr[i], freqCount.get(arr[i]) + 1) ;
            }
            else {
                freqCount.put(arr[i], 1) ;
            }
        }
        for (int i = 0 ; i < arr.length ; i++) {
            if (freqCount.get(arr[i]) == 1)
                return arr[i] ;
        }
        return  null ;
    }

    public static void main(String[] args) {
        int [] arr = {9, 4, 9, 6, 7, 4 } ;
        System.out.println (firstNonRepeatingInt(arr)) ;
    }
}
