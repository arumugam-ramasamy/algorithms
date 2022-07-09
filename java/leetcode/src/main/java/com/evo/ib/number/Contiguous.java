package com.evo.ib.number;

import java.util.HashSet;
import java.util.Set;

public class Contiguous {

    public static boolean contigous (int [] arr) {
        if (arr == null || arr.length <= 1) return true ;
        Set<Integer> contig = new HashSet<>() ;
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;

        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] < min) min = arr[i] ;
            if (arr[i] > max) max = arr[i] ;
            contig.add(arr[i]) ;
        }

        for (int i = min+1 ; i < max-- ; i++) {
            if (contig.contains(i) == false) return false ;
        }
        return true ;
    }

    public static void main(String[] args) {
        int [] arr = {5, 2, 3, 6, 4, 4, 6, 6, 7} ;
        System.out.println (contigous(arr)) ;
        int[] arr2 = {10, 11, 11, 13, 14, 13, 14, 15} ;
        System.out.println(contigous(arr2));
    }
}
