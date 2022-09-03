package com.evo.ib.top.ll;

import com.evo.ib.linkedlist.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head ;
        ListNode p1 = head ;
        ListNode p2 = head.next;
        ListNode res = head ;
        ListNode connectNode = head.next ;

        while (p1 != null && p2 != null) {
            if (p2.next == null) break ;
            p1.next = p2.next ;
            p1 = p1.next ;
            p2.next = p1.next ;
            p2 = p2.next ;

        }
        p1.next = connectNode ;
        return res ;
    }
}
