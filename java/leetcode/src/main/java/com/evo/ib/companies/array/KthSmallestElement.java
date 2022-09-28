package com.evo.ib.companies.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static int kthSmallestElement (int [] arr, int k) {
        if (arr == null || arr.length < k) return -1 ;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer ;
            }
        }) ;

        for (int i = 0 ; i < k ; i++)
            pq.add(arr[i]) ;

        for (int i = k ; i < arr.length ; i++) {
            if (pq.peek() < arr[i]) continue ;
            pq.add(arr[i]) ;
            pq.remove() ;
            //System.out.println("size is " + pq.size());
        }

        return  pq.peek() ;
    }

    public static void main(String[] args) {
        int [] arr = {3, 4,5,78, 9, 1, 5, 8, 22} ;
        System.out.println(kthSmallestElement(arr, 2));
       System.out.println(kthSmallestElement(arr, 3));
        System.out.println(kthSmallestElement(arr, 4));
        System.out.println(kthSmallestElement(arr, 5));
    }

}
