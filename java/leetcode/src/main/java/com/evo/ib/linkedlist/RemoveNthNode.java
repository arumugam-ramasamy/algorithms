package com.evo.ib.linkedlist;

public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode NthNode = head ;
        ListNode  prev ;
        ListNode TailNode = head ;

        int i = 0 ;
        prev = null ;
        while ((TailNode != null) && (i < n)) {
            TailNode = TailNode.next ;
            i++ ;
        }
        if (TailNode == null && i < n) return head ;
        while (TailNode != null) {
            TailNode = TailNode.next ;
            prev=NthNode ;
            NthNode = NthNode.next ;
        }

        if (NthNode.next != null) {
            NthNode.val = NthNode.next.val ;
            NthNode.next = NthNode.next.next;
        }
        else {
            if (NthNode == head) {
                head = null ;
                NthNode = null ;
            }
            else {
                prev.next = null ;
                NthNode = null ;
            }
        }

        return head ;
    }
}
