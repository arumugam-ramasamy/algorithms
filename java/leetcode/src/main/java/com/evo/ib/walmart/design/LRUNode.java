package com.evo.ib.walmart.design;

public class LRUNode {
    public int key, value ;
    public LRUNode prev ;
    public LRUNode next ;

    public LRUNode(int key, int value) {
        this.key = key ;
        this.value = value ;
        this.next = null ;
        this .prev = null ;
    }

    public LRUNode() {
        this(0, 0) ;
    }
}
