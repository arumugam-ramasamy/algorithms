package com.evo.ib.google.test;

import com.evo.ib.google.LinkedListProblems;
import com.evo.ib.linkedlist.NewListNode;

import java.util.*;

public class TestLinkedList {

    public static void testLinkedList () {
        Random rand = new Random() ;
        int upperbound = 100 ;
        LinkedListProblems ll = new LinkedListProblems() ;
        List<NewListNode> nln = new ArrayList<>() ;
        int count = rand.nextInt(20) + 1 ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            ll.insertNode(val);
            int dec = rand.nextInt(10) ;
            if (dec < 8) nln.add(ll.getCur()) ;
            int ind = 0 ;
            if (nln.size() != 0) ind = rand.nextInt(nln.size()) ;
            if (ind < nln.size() && dec < 6) {
                ll.getCur().setArbitrary(nln.get(ind));
            }
        }

        ll.printll(ll.getHead());
        NewListNode newHead = ll.deepCopy();
        ll.printll(newHead);

    }

    public static void main(String[] args) {
        testLinkedList();
    }

}