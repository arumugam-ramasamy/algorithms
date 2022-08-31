package com.evo.ib.linkedlist;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next != null) {
            node.val = node.next.val ;
            node.next = node.next.next ;
            return ;
        }
        if (node.next == null) {
            node = null ;
        }

    }
}
