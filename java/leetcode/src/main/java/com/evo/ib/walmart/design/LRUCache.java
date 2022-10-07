package com.evo.ib.walmart.design;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, LRUNode > getCache = new HashMap<>() ;
    LRUNode head ;
    LRUNode tail ;
    int capacity ;



    public LRUCache (int capacity) {
        this.capacity = capacity ;
        head = new LRUNode() ;
        tail = new LRUNode () ;
        head.next = tail ;
        tail.prev = head ;
    }

    public LRUNode getKey(int key) {
        if (!getCache.containsKey(key)) {
            return null ;
        }
        LRUNode toget = getCache.get(key) ;
        remove(toget) ;
        insertHead(toget) ;
        return toget ;
    }

    public void setCache (int key, int value) {

        if (getCache.containsKey(key)){
            LRUNode access = getCache.get(key) ;
            remove(access);
            access.value = value ;
            getCache.put(key, access) ;
            insertHead(access);

        }
        else {
            LRUNode newdata = new LRUNode() ;
            newdata.key = key ;
            newdata.value = value ;
            if (getCache.size() == this.capacity) {
                removeLRU() ;
            }
            insertHead(newdata);
        }
    }

    public void insertHead(LRUNode node) {
        LRUNode next = head.next ;
        node.prev = head ;
        node.next = next ;
        next.prev = node ;
        head.next = node ;
        getCache.put(node.key, node) ;
    }

    public void remove (LRUNode node) {
        LRUNode next = node.next ;
        LRUNode prev = node.prev ;
        prev.next = next ;
        next.prev = prev ;
        getCache.remove(node.key) ;
    }

    public void removeLRU () {
        LRUNode remNode = tail.prev ;
        LRUNode prev = tail.prev.prev ;
        prev.next = tail ;
        tail.prev = prev ;
        getCache.remove(remNode.key) ;

    }

    public void printCache () {
        LRUNode cur = head.next ;
        int count = getCache.size() ;
        for (int i = 0 ; i < count ; i++) {
            if (cur == null) break ;
            System.out.print("(" + cur.key + "," + cur.value + ") ==>" ) ;
            cur = cur.next ;
        }
        System.out.println("null") ;

    }

    public static void main(String[] args) {

        System.out.println("hi");
        LRUCache lrucache = new LRUCache(4) ;
        lrucache.setCache(1, 10);
        lrucache.setCache(2, 20);
        lrucache.setCache(3, 30);
        lrucache.setCache(4, 40);
        lrucache.printCache();
        lrucache.setCache(5, 50);
        lrucache.printCache();
        lrucache.setCache(4, 60);
        lrucache.printCache();
    }

}
