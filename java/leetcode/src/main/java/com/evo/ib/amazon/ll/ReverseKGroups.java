package com.evo.ib.amazon.ll;

import com.evo.ib.linkedlist.ListNode;

public class ReverseKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;
        int noNodes = 0 ;
        ListNode checkCurrent = head ;
        while (checkCurrent != null && noNodes < k) {
            checkCurrent = checkCurrent.next ;
            noNodes++ ;
        }
        if (noNodes < k)  return head ;
        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverseKGroup(next, k);

        // prev is now head of input list
        return prev;
    }
}
