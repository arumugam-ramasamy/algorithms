package com.evo.ib.microsoft.ll;
/*
Given the head of a singly linked list, reverse the list, and return the reversed list.



Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000


Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

 */
import com.evo.ib.linkedlist.LinkedList;
import com.evo.ib.linkedlist.ListNode;
import sun.awt.image.ImageWatched;

import java.util.Random;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.getNext() == null) return head ;
        ListNode cur = head ;
        ListNode prev = null ;
        ListNode next = head.getNext() ;
        while (cur != null) {
            next = cur.getNext() ;
            cur.setNext(prev);
            prev = cur ;
            cur = next ;

        }
        return prev ;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList() ;
        int upperbound = 100 ;
        Random rand = new Random() ;
        int count = rand.nextInt(20) + 1 ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            ll.insertNode(val) ;
        }
        ll.printll(ll.getHead());
        ListNode rev = reverseList(ll.getHead()) ;
        ll.printll(rev);
    }
}
