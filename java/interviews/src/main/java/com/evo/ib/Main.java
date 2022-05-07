package com.evo.ib;


import com.evo.ib.linkedlist.LinkedCompare;
import com.evo.ib.linkedlist.LinkedList;
import com.evo.ib.linkedlist.ListNode;

import java.util.*;

public class Main {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2 ;
        if (l2 == null) return l1 ;

        int sum ;
        int carry = 0 ;
        ListNode prev = null ;
        ListNode head = l1 ;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry ;
            if (sum >= 10) {
                carry = sum / 10 ;
                sum = sum % 10 ;

            }
            else carry = 0 ;
            l1.val = sum ;
            prev = l1 ;
            l1 = l1.next ;
            l2 = l2.next ;
        }

        if (l1 == null && l2 != null) {
            prev.next = l2 ;
            l1 = l2 ;
            while (l1 != null) {
                sum = carry + l1.val ;
                if (sum >= 10) {
                    carry = sum / 10 ;
                    sum = sum % 10 ;

                }
                else carry = 0 ;
                l1.val = sum ;
                prev = l1 ;
                l1 = l1.next ;
            }

        }

        if (l1 != null && l2 == null) {
            while (l1 != null) {
                sum = carry + l1.val ;
                if (sum >= 10) {
                    carry = sum / 10 ;
                    sum = sum % 10 ;

                }
                else carry = 0 ;
                prev = l1 ;
                l1.val = sum ;
                l1 = l1.next ;
            }
        }
        if (carry > 0) {
            l1 = new ListNode () ;
            l1.val = carry ;
            prev.next = l1 ;
        }
        return head ;
    }

    public static ListNode mergeKLinkedList (List<ListNode> lls){
        Comparator<LinkedCompare> dataSorter = Comparator.comparing(LinkedCompare::getData);
        Queue<LinkedCompare> priorityQueue = new PriorityQueue<>(dataSorter);
        for (int i = 0 ; i < lls.size() ; i++) {
            priorityQueue.add(new LinkedCompare(lls.get(i).getVal(), i)) ;
        }
        ListNode headMerged = null ;
        ListNode curMerged = headMerged ;
       LinkedCompare curQueue = priorityQueue.poll() ;

        while (curQueue != null) {
            ListNode curNode = lls.get(curQueue.getInd()) ;
            if (headMerged == null) {
                headMerged = curNode ;
                curMerged = headMerged ;
            }
            else {
                curMerged.setNext(curNode);
                curMerged = curMerged.getNext() ;
            }
            curNode = curNode.getNext() ;
            lls.set(curQueue.getInd(), curNode)  ;
            if (curNode != null)
                priorityQueue.add(new LinkedCompare(curNode.getVal(), curQueue.getInd())) ;
            curQueue = priorityQueue.poll() ;
        }
        curMerged.setNext(null);
        return headMerged ;
    }

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
        l2.printll(mergeKLinkedList(arrList))  ;
    }

    public static void main(String[] args) {
	// write your code here

       // l2.printll(addTwoNumbers(ll.getHead(), l2.getHead()));
        //ll.printll(ll.mergeSortedLinkedList(ll.getHead(), l2.getHead())) ;
 /*        ListNode rev = ll.reverseLL() ;
         ll.printll(rev);
         ll.printll(ll.middleLL());
*/
        testMergeLinkedList();

    }
}
