package com.evo.ib.top.ll;

import com.evo.ib.linkedlist.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false ;
        ListNode slow = head ;
        ListNode fast = head ;
        slow = head.next ;
        if (slow != null) fast = slow.next ;
        while (fast != null) {
            slow = slow.next ;
            if (slow == null)break ;
            fast = fast.next ;
            if (fast != null) fast = fast.next ;
            else break ;
            if (slow == fast) return true ;
        }
        return false ;
    }
}
