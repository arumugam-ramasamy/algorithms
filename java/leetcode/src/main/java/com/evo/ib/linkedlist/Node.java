package com.evo.ib.linkedlist;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node () {
        next = random = null ;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getRandom() {
        return random;
    }

    public void setRandom(Node random) {
        this.random = random;
    }
}

