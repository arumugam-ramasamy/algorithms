package com.smic.practice.problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<String, MemNode> kmem ;
    int CAPACITY ;
    MemNode head ;
    MemNode tail ;

    LRUCache (int cap) {
        this.CAPACITY = cap ;
        kmem = new HashMap<>() ;
        head = null ;
        tail = null ;
    }

    public Map<String, MemNode> getKmem() {
        return kmem;
    }

    public void setKmem(Map<String, MemNode> kmem) {
        this.kmem = kmem;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public MemNode getHead() {
        return head;
    }

    public void setHead(MemNode head) {
        this.head = head;
    }

    public MemNode getTail() {
        return tail;
    }

    public void setTail(MemNode tail) {
        this.tail = tail;
    }
}
