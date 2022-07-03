package com.evo.ib.linkedlist;

import org.w3c.dom.Node;

import java.util.*;

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

    public boolean deleteNode (int data) {
        if (getHead() == null) return false ;
        ListNode temp = getHead() ;

        while (temp != null) {
            if (temp.getVal() == data) {
                if (temp == getHead()) {
                    setHead(temp.getNext()); ;
                    temp = null ;
                    return true ;
                }

                if (temp.getNext() == null) {
                    temp = null ;
                    return true ;
                }

                temp.setVal(temp.getNext().getVal());
                temp.setNext(temp.getNext().getNext());
                return true ;

            }
            temp = temp.getNext();
        }
        return false ;
    }

    public int smallLL(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            l1 = l1.getNext() ;
            l2 = l2.getNext() ;
        }
        if (l1 == null) return 1 ;
        return 2 ;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int which = smallLL(headA, headB) ;
        Set<Integer> smallElems = new HashSet<>() ;
        return null ;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2 ;
        if (l2 == null) return l1 ;

        int sum ;
        int carry = 0 ;
        ListNode prev = null ;
        ListNode head = l1 ;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry ;
            if (sum >= 10) {
                carry = sum / 10 ;
                sum = sum % 10 ;

            }
            else carry = 0 ;
            l1.val = sum ;
            prev = l1 ;
            l1 = l1.next ;
            l2 = l2.next ;
        }

        if (l1 == null && l2 != null) {
            prev.next = l2 ;
            l1 = l2 ;
            while (l1 != null) {
                sum = carry + l1.val ;
                if (sum >= 10) {
                    carry = sum / 10 ;
                    sum = sum % 10 ;

                }
                else carry = 0 ;
                l1.val = sum ;
                prev = l1 ;
                l1 = l1.next ;
            }

        }

        if (l1 != null && l2 == null) {
            while (l1 != null) {
                sum = carry + l1.val ;
                if (sum >= 10) {
                    carry = sum / 10 ;
                    sum = sum % 10 ;

                }
                else carry = 0 ;
                prev = l1 ;
                l1.val = sum ;
                l1 = l1.next ;
            }
        }
        if (carry > 0) {
            l1 = new ListNode () ;
            l1.val = carry ;
            prev.next = l1 ;
        }
        return head ;
    }

    public static ListNode mergeKLinkedList (List<ListNode> lls){
        Comparator<LinkedCompare> dataSorter = Comparator.comparing(LinkedCompare::getData);
        Queue<LinkedCompare> priorityQueue = new PriorityQueue<>(dataSorter);
        for (int i = 0 ; i < lls.size() ; i++) {
            priorityQueue.add(new LinkedCompare(lls.get(i).getVal(), i)) ;
        }
        ListNode headMerged = null ;
        ListNode curMerged = headMerged ;
        LinkedCompare curQueue = priorityQueue.poll() ;

        while (curQueue != null) {
            ListNode curNode = lls.get(curQueue.getInd()) ;
            if (headMerged == null) {
                headMerged = curNode ;
                curMerged = headMerged ;
            }
            else {
                curMerged.setNext(curNode);
                curMerged = curMerged.getNext() ;
            }
            curNode = curNode.getNext() ;
            lls.set(curQueue.getInd(), curNode)  ;
            if (curNode != null)
                priorityQueue.add(new LinkedCompare(curNode.getVal(), curQueue.getInd())) ;
            curQueue = priorityQueue.poll() ;
        }
        curMerged.setNext(null);
        return headMerged ;
    }



}
