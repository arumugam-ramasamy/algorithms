package com.evo.ib.linkedlist;

public class PalindromeLL {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true ;
        if (head.next == null)return true ; ;
        ListNode  middle  = reverseLL(middleLL(head)) ;

        while ((head != null) && (middle != null)) {
            if (head.val != middle.val) return false ;
            head = head.next ;
            middle = middle.next ;
        }
        return true ;
    }

    public static ListNode middleLL(ListNode ll) {
        ListNode slow = ll.next ;
        ListNode prev = ll ;
        ListNode fast = slow.next ;

        while (fast != null) {
            prev = slow ;
            slow  = slow.next ;
            fast = fast.next ;
            if (fast == null) break ;
            fast = fast.next ;
        }
        prev.next = null ;
        return  slow ;
    }

    public static ListNode reverseLL(ListNode ll) {
        ListNode prev = null ;
        ListNode cur = ll ;
        ListNode next = null ;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev ;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode() ;
        node.val = 1 ;
        node.next = new ListNode() ;
        node.next.val = 0 ;
        node.next.next = new ListNode() ;
        node.next.next.val = 0 ;
        node.next.next.next = null ;
        System.out.println (isPalindrome(node)) ;
    }
}
