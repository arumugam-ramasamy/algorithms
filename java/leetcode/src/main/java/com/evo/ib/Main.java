package com.evo.ib;


import com.evo.ib.arrays.ArrayProblems;
import com.evo.ib.graph.EasyProblems;
import com.evo.ib.linkedlist.LinkedCompare;
import com.evo.ib.linkedlist.LinkedList;
import com.evo.ib.linkedlist.ListNode;
import com.evo.ib.math.Fibonacci;
import com.evo.ib.sort.MergeSort;
import com.evo.ib.strings.StringHardProblems;
import com.evo.ib.strings.StringProblems;
import com.evo.ib.tree.BinaryTreeHard;
import com.evo.ib.tree.TreeNode;
import com.evo.ib.tree.BinaryTree;

import java.util.*;

public class Main {


    public static void testRemoveDuplicates () {
        List <Integer> arr = new ArrayList<>() ;
        Random rand = new Random() ;
        int prov = 0 ;
        int upperbound =5 ;
        for (int i = 0 ; i < 100 ; i++) {
            if (rand.nextInt(100) < 25)
                arr.add(rand.nextInt(upperbound) + (i* upperbound)) ;
            else {
                if (i > 0)
                arr.add(arr.get(i - 1));
                else {
                    arr.add(0) ;
                }
            }
        }
        ArrayProblems.printArr(arr) ;
        ArrayProblems.removeDuplicates(arr);
        ArrayProblems.printArr(arr);

    }

    public static int [] generateRandomSortedArr(int total ) {
        int[] arr = new int[total] ;
        Random rand = new Random() ;

        for (int i = 0 ; i < total ; i++) {
            arr[i] = (rand.nextInt(10)  + i*10 );
        }
        return arr ;
    }

    public static int [] generateRandomArr(int total ) {
        int[] arr = new int[total] ;
        Random rand = new Random() ;

        for (int i = 0 ; i < total ; i++) {
                arr[i] = (rand.nextInt(100) );
        }
        return arr ;
    }

    public static void testRemoveDuplicateaArr () {
        int total = 2 ;
        int[] arr = new int[total] ;
        Random rand = new Random() ;
        int prov = 0 ;
        int upperbound =5 ;
        for (int i = 0 ; i < total ; i++) {
            if (rand.nextInt(100) < 25)
                arr[i] = (rand.nextInt(upperbound) + (i* upperbound) );
            else {
                if (i > 0)
                    arr[i] = arr[i - 1];
                else {
                    arr[i] = 0 ;
                }
            }
        }
        ArrayProblems.printpureAr(arr); ;
        int j = ArrayProblems.removeDuplicatesArr(arr);
        //ArrayProblems.printpureAr(arr);

    }
    public static void testRotateArr() {
        int total = 10 ;
        int[] arr = new int[total] ;

        for (int i = 0 ; i <  total ; i++) {
           arr[i] = i ;
        }
        ArrayProblems.printpureAr(arr);
        ArrayProblems.rotateArr(arr, 2);
    }
    
    public static void testReverse () {
        int upperbound = 100 ;
        LinkedList ll = new LinkedList() ;
        Random rand = new Random() ;
        int count = rand.nextInt(10) + 1 ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            ll.insertNode(val) ;
        }
        ll.printll(ll.getHead());
        ll.printll(ll.reverseLL());

        LinkedList l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        l2.printll(l2.reverseLL());

    }

    public static void testQuickSort () {
        int [] arr = generateRandomArr(100) ;
        ArrayProblems.printpureAr(arr);
        ArrayProblems.iterativeQsort(arr);
        ArrayProblems.printpureAr(arr);

    }

    public static void testSingleNumber() {
        int count = 20 ;
        int [] arr = generateRandomArr(count) ;
        int [] arrnew = new int[2*count - 1] ;
        for (int i = 0 ; i < (count-1) ; i++) {
            arrnew[i] = arr[i] ;
            arrnew[i+(count-1)] = arr[i] ;
        }
        arrnew[2 * (count-1)] = arr[count-1] ;
        ArrayProblems.printpureAr(arr);
        ArrayProblems.printpureAr(arrnew);
        System.out.println (ArrayProblems.singleNumber(arrnew)) ;
    }



    public static void testFibonacci () {
        Fibonacci fib = new Fibonacci() ;
        fib.setFibNum(20);
        System.out.println(fib.calcFib() + " , " + fib.calcFibMem() + " , " + fib.calcFibByFormula());
    }

    public static void testMergeSort () {
        MergeSort mergeSort = new MergeSort() ;
        mergeSort.printArr();
        mergeSort.mergeSort(mergeSort.getArr(), mergeSort.getArr().length);
        mergeSort.printArr();
    }

    public static void main(String[] args) {
       //testBinaryTree () ;
      //  testFibonacci();
      //  testMergeSort();
       // EasyProblems.testStar();
       //// StringHardProblems.testKMP();
       // StringProblems.rotation("abcd", "cdab") ;
       /*String str = "supercalifraglistic" ;
      /* System.out.println(str);
        System.out.println (StringProblems.reverseString(str))  ;
        System.out.println(StringProblems.isAnagram1("anagram", "nagaram"));
        System.out.println(StringProblems.firstUniqueChar("loveleetcode")) ;
        System.out.println(StringHardProblems.longestSubUniqueChars("geeksforgeeks"));
        System.out.println(StringHardProblems.longestBestUniwueChar("geeksforgeeks"));*/

    }
}
