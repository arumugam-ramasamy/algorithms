package com.evo.ib.linkedlist.test;

import com.evo.ib.linkedlist.LinkedList;
import com.evo.ib.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLinkedList {
    public static void testMergeLinkedList() {
        Random rand = new Random() ;
        int upperbound = 100 ;
        List<ListNode> arrList = new ArrayList<>() ;
        LinkedList ll = new LinkedList() ;
        int count = rand.nextInt(10) + 1 ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            ll.insertNode(val) ;
        }
        ll.printll(ll.getHead());
        arrList.add(ll.getHead()) ;
        LinkedList l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        arrList.add(l2.getHead()) ;
        l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        arrList.add(l2.getHead()) ;
        l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        arrList.add(l2.getHead()) ;
        l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        arrList.add(l2.getHead()) ;
        l2.printll(LinkedList.mergeKLinkedList(arrList))  ;
    }

    public static void testDeleteList () {
        Random rand = new Random() ;
        int upperbound = 100 ;
        List<ListNode> arrList = new ArrayList<>() ;
        LinkedList ll = new LinkedList() ;
        int count = rand.nextInt(10) + 1 ;
        int find = rand.nextInt(10) + 1 ;
        int delVal = -1;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            ll.insertNode(val) ;
            if (i == find) delVal = val ;
        }
        System.out.println ("The chosen delete val is index and val " + find + "," + delVal) ;
        ll.printll(ll.getHead());
        ll.deleteNode(delVal) ;
        ll.printll(ll.getHead()) ;
    }

    public static void main(String[] args) {
        //testDeleteList();
        testMergeLinkedList();
    }

}
