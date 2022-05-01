package com.evo.ib.linkedlist;

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
}
