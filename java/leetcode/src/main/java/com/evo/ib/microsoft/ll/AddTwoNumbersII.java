package com.evo.ib.microsoft.ll;

import com.evo.ib.linkedlist.ListNode;

public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1) ;
        l2 = reverseList(l2) ;
        l1 = addTwoNumbersHelp(l1, l2) ;
        l1 = reverseList(l1) ;
        return l1 ;
    }

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
    public static ListNode addTwoNumbersHelp(ListNode l1, ListNode l2) {
        if (l1 == null) return l2 ;
        if (l2 == null) return l1 ;

        ListNode head = l1 ;
        ListNode prev = null ;
        int sum = 0 ;
        int carry = 0 ;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry ;
            if (sum >= 10) {
                carry = sum /10 ;
                sum = sum % 10 ;
            }
            else carry = 0 ;
            l1.val = sum ;
            prev = l1 ;
            l1 = l1.next ;
            l2 = l2.next ;
        }

        while (l2 != null) {
            sum = l2.val+ carry ;
            if (sum >= 10) {
                carry = sum /10 ;
                sum = sum % 10 ;
            }
            else carry = 0 ;
            prev.next = l2 ;
            l2.val = sum ;
            prev = l2 ;
            l2 = l2.next ;
        }

        while (l1 != null) {
            sum = l1.val + carry ;
            if (sum >= 10) {
                carry = sum /10 ;
                sum = sum % 10 ;
            }
            else carry = 0 ;
            prev.next = l1 ;
            l1.val = sum ;
            prev = l1 ;
            l1 = l1.next ;
        }

        if (carry > 0) {
            ListNode car = new ListNode();
            car.val = carry ;
            prev.next = car ;
        }
        return head ;
    }
}
