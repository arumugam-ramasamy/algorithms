package com.evo.ib.linkedlist;

import org.w3c.dom.Node;

import java.util.List;

public class LinkedList {
    ListNode head ;
    ListNode cur ;

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public ListNode getCur() {
        return cur;
    }

    public void setCur(ListNode cur) {
        this.cur = cur;
    }

    public LinkedList() {
        head = null ;
        cur = null ;
    }

    public void insertNode (int data) {
        ListNode listNode = new ListNode() ;
        listNode.setVal(data);
        listNode.setNext(null);
        if (head == null) {
            head = listNode;
            cur = head ;
            return ;
        }
        cur.setNext(listNode);
        cur = cur.getNext();
    }

    public void printll (ListNode p) {
        while (p != null) {
            System.out.print (p.getVal() + "--->") ;
            p = p.getNext() ;
        }
        System.out.println("null") ;
    }
    // This reverses the existing list
    public ListNode reverseLL () {
        ListNode rev = getHead() ;

        if (rev == null) return null ;
        ListNode prev = null ;
        ListNode next = rev.getNext() ;
        while (rev != null ) {
            rev.setNext(prev); ;
            prev = rev ;
            rev = next ;
            if (rev != null)
                next = rev.getNext() ;
        }
        setHead(prev);
        return prev ;
    }

    public ListNode middleLL () {
        ListNode slowListNode = getHead() ;
        ListNode fastListNode = getHead() ;
        while (fastListNode != null) {

            fastListNode = fastListNode.getNext() ;
            if (fastListNode != null) {
                fastListNode = fastListNode.getNext() ;
            }
            else
                break;
            slowListNode = slowListNode.getNext() ;
        }
        return slowListNode;
    }

    public ListNode mergeSortedLinkedList (ListNode l1, ListNode l2) {

        ListNode  dummyNode = new ListNode() ;
        dummyNode.setVal( -1);
        ListNode headDummyNode = dummyNode ;
        //ListNode prev = null  ;

        if (l1 == null) return l2 ;
        if (l2 == null) return l1 ;

        while (l1 != null && l2 != null) {
            ListNode insNode ;
            if (l1.getVal() <= l2.getVal()) {
               insNode = l1 ;
                l1 = l1.getNext() ;
            }
            else {
               insNode = l2 ;
               l2 = l2.getNext() ;
            }
            dummyNode.setNext(insNode);
            //prev = dummyNode ;
            dummyNode = dummyNode.getNext() ;

        }

        if (l1 == null) dummyNode.setNext(l2);
        if (l2 == null) dummyNode.setNext(l1);
        return headDummyNode.getNext();
    }
}
