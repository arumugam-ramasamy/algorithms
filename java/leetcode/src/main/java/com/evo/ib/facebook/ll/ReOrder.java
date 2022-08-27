package com.evo.ib.facebook.ll;

import com.evo.ib.linkedlist.LinkedList;
import com.evo.ib.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]


Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
 */
public class ReOrder {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) System.out.println("[]") ;
        ListNode oneList = head ;
        ListNode secondList = middle(head) ;
        secondList = reverseLL(secondList) ;
        ListNode firstnext = null ;
        ListNode secondnext = null ;
        while (secondList != null) {
            firstnext = oneList.next ;
            secondnext = secondList.next ;
            oneList.next = secondList ;
            secondList.next = firstnext ;
            oneList = firstnext ;
            secondList = secondnext ;
        }
        ListNode cur = head ;
        System.out.print ("[" + cur.val) ;
        cur = cur.next;
        while (cur != null) {
            System.out.print ("," +  cur.val) ;
            cur=cur.next;
        }
        System.out.println("]") ;
    }

    public static ListNode middle (ListNode root) {
        if (root == null) return root ;
        ListNode prev = null ;
        ListNode slow = root ;
        ListNode fast = root ;

        while (fast != null) {
            prev = slow ;
            slow = slow.next ;
            fast = fast.next ;
            if (fast != null)
                fast = fast.next ;
            else break ;
        }
        prev.next = null ;
        return  slow ;
    }

    public static ListNode reverseLL (ListNode root) {
        ListNode prev = null ;
        ListNode cur = root ;
        ListNode next ;

        while (cur != null) {
            next = cur.next ;
            cur.next = prev ;
            prev = cur ;
            cur = next ;
        }

        return prev ;
    }

    public static void main(String[] args) {
        Random rand = new Random() ;
        int upperbound = 100 ;
        LinkedList ll = new LinkedList() ;
        int count = rand.nextInt(30) + 1 ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            ll.insertNode(val) ;
        }
        ll.printll(ll.getHead());
        reorderList(ll.getHead()) ;
    }

}
