package com.evo.ib;


import com.evo.ib.linkedlist.LinkedList;
import com.evo.ib.linkedlist.ListNode;

import java.util.Random;

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

    public static void main(String[] args) {
	// write your code here
        Random rand = new Random() ;
        int upperbound = 100 ;
        LinkedList ll = new LinkedList() ;
        int count = 10 ;
        for (int i = 0 ; i <  count ; i++) {
            ll.insertNode(i);
            //int val = rand.nextInt(upperbound) % 10 ;
          /*  if (i > (count/2) ) {
                //while (val == 0)
                    //val = rand.nextInt(upperbound) % 10 ;
                    val = i ;
                // val = 9 ;
            }
            //ll.insertNode(val);
        */

        }
        ll.printll(ll.getHead());
        LinkedList l2 = new LinkedList() ;
        count = 6 ;
        for (int i = 0 ; i <  6 ; i++) {
            /*int val = rand.nextInt(upperbound) % 10 ;
            if (i == (count -1) ) {
                while (val == 0)
                   // val = rand.nextInt(upperbound) % 10 ;
                    val = i ;
            }*/
            l2.insertNode(i);
        }
        l2.printll(l2.getHead());
       // l2.printll(addTwoNumbers(ll.getHead(), l2.getHead()));
        ll.printll(ll.mergeSortedLinkedList(ll.getHead(), l2.getHead())) ;
 /*        ListNode rev = ll.reverseLL() ;
         ll.printll(rev);
         ll.printll(ll.middleLL());
*/


    }
}
