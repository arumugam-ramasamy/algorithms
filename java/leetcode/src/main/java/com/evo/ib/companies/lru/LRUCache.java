package com.evo.ib.companies.lru;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public class Node {
        int key, value ;
        Node prev ;
        Node next ;

        Node (int key, int value) {
            this.key = key ;
            this.value = value ;
            this.next = null ;
            this .prev = null ;
        }

        Node () {
            this(0, 0) ;
        }
    }

    private int capacity, curCount ;
    private Node head, tail ;
    private Map<Integer, Node> nodeRef ;

    public LRUCache (int capacity) {
        this.capacity  = capacity ;
        this.curCount = 0 ;
        head = new Node () ;
        tail = new Node () ;
        head.next = tail ;
        head.prev = null ;
        tail.prev = head ;
        tail.next = null;
        nodeRef = new HashMap<>() ;
    }
    public int get(int key) {
        Node n = nodeRef.get(key) ;
        if (n == null) {
            return -1 ;
        }
        update(n) ;
        return n.value ;
    }

    public void put(int key, int value) {
        Node n = nodeRef.get(key) ;
        if (n == null) {
            n = new Node(key, value);
            add(n) ;
            nodeRef.put(key, n) ;
            ++(this.curCount) ;
        }
        else {
            n.value = value ;
            update(n) ;
        }
        if (this.curCount > this.capacity) {
            Node todel = tail.prev ;
            remove(todel) ;
            nodeRef.remove(todel.key) ;
            --(this.curCount);
        }
    }

    public void remove (Node n) {
        Node before = n.prev;
        Node after = n.next ;
        after.prev = before ;
        before.next = after ;
    }

    public void add(Node node) {
       node.next = head.next;
       head.next = node ;
       node.prev= head;
       node.next.prev = node ;
    }

    public void update(Node n) {
       remove(n) ;
       add(n ) ;
    }
}
