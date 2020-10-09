package com.smic.practice.linkedlist;



/**
 * Created by PranavsMac on 9/27/20.
 */
public class LinkedItems {

    private LinkedList head  = null ;
    private LinkedList cur = null ;

    public LinkedItems () {
        head  = null ;
        cur = null ;
    }

    public LinkedList getHead () {
        return head ;
    }

    public LinkedList getTail () {
        return cur ;
    }
    public LinkedItems (int i) {
        LinkedList node = new LinkedList(i) ;
        if (head == null) {
            head = node  ;
            cur = head ;
        }

    }

    public void insertItems(int i) {
        LinkedList node = new LinkedList(i) ;
        if (head == null) {
            head = node  ;
            cur = head ;
        }
        else {
            cur.setNext (node) ;
            cur = cur.getNext() ;
        }
    }

    public LinkedList middle () {

        LinkedList slow = head ;

        if (slow == null) {
            return null ;
        }

        LinkedList fast = slow.getNext() ;

        if (fast == null) {
            return slow ;
        }

        fast = fast.getNext() ;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext() ;
            fast = fast.getNext().getNext() ;
        }

        return  slow ;
    }

    public LinkedList detectLoop () {

        LinkedList slow = head ;

        if (slow == null) {
            return null ;
        }

        LinkedList fast = slow.getNext() ;

        if (fast == null) {
            return null ;
        }

        fast = fast.getNext() ;

        while (fast != null && fast.getNext() != null && slow != fast ) {
            slow = slow.getNext() ;
            fast = fast.getNext().getNext() ;
        }

        System.out.println ("detected loop") ;
        if (slow == fast && fast != null) {
            slow = head ;
            while (slow != fast) {
                System.out.println ("in here") ;
                slow = slow.getNext() ;
                fast = fast.getNext() ;
                System.out.println (slow.getData() +
                        " " + fast.getData()) ;
            }
            return slow ;
        }
        else {
            return null ;
        }

    }


    public void printList () {
        LinkedList current = head ;
        int counter = 1 ;

        while (current != null) {
            System.out.print(current.getData() + " ------ >") ;
            ++counter;
            current = current.getNext() ;
        }
        System.out.println("null");
    }

    public void createLoop() {

        LinkedList any =  head ;
        int i = 0 ;
        while (i < 10) {
            i++ ;
            any = any.getNext() ;
        }
        cur.setNext(any) ;



    }

    public LinkedList kthFromTail (int k) {

        LinkedList kdist = head ;
        LinkedList kthItem = head ;
        if( k == 0) {
            return head ;
        }
        if (head == null) {
            return null ;
        }
        int count = 0 ;
        while (count < k  && kdist != null) {
            ++count ;
            kdist = kdist.getNext() ;
        }

        if (kdist == null) {
            return null ;
        }

        while (kdist != null) {
            kdist = kdist.getNext() ;
            kthItem = kthItem.getNext() ;
        }

        return kthItem ;

    }

    public void reverseLinkedList () {

        LinkedList pPrev = null ;
        LinkedList pcur = head ;
        while (pcur != null) {
            LinkedList pNext = pcur.getNext() ;
            pcur.setNext(pPrev) ;
            pPrev = pcur ;
            pcur = pNext ;
        }

        head = pPrev ;
    }

    public  void deleteNode (LinkedList node) {

        if (node.getNext() == null) {
            LinkedList del = head ;
            while (del.getNext() != node) {
                del  = del.getNext() ;
            }
            del.setNext(null) ;
            cur = del ;
            node = null ;
        }
        else {
            node.setData(node.getNext().getData()) ;
            LinkedList delete = node.getNext() ;
            node.setNext(delete.getNext()) ;
            delete = null ;

        }
    }

    public LinkedList getNode (int i) {
        int count = 0 ;
        LinkedList  node = head ;
        if (node == null) {
            return null ;
        }

        while ((node != null) && (count < i)) {
            node = node.getNext() ;
            count++;
        }

        return node ;
    }

    public static void main (String args[]) {

        LinkedItems items  = new LinkedItems (1) ;

        for (int i = 2 ; i <= 10 ; i++) {

            items.insertItems(i) ;
        }

        items.printList();
        System.out.println (items.middle().getData()) ;
        LinkedList kthitem = items.kthFromTail(110) ;
        if (kthitem != null) {
            System.out.println (kthitem.getData()) ;
        }
        else{
            System.out.println ("does not exist") ;
        }
        items.reverseLinkedList() ;
        items.printList() ;
        items.reverseLinkedList() ;
        items.printList() ;
        LinkedList getnode = items.getNode(9) ;
        System.out.println (getnode.getData()) ;
        items.deleteNode(getnode) ;
        items.deleteNode(items.getTail()) ;
        items.printList() ;
    }
}
