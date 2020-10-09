package com.smic.practice.linkedlist;

/**
 * Created by PranavsMac on 9/27/20.
 */
public class LinkedList {

    private int data ;
    private LinkedList next ;

    public int getData () {
        return data ;
    }

    public LinkedList getNext () {
        return next ;
    }

    public LinkedList (int value) {
        this.data = value ;
        this.next = null ;
    }

    public void setData (int value) {
        this.data = value ;
    }

    public void setNext(LinkedList nextval) {
        this.next = nextval ;
    }

}

