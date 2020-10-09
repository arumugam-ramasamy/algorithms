package com.smic.practice.problems;

public class MemNode {
    String key ;
    int value ;
    MemNode pre ;
    MemNode next ;

    MemNode(String k, int val) {
        this.key = k ;
        this.value = val ;
        this.pre = null ;
        this.next = null ;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MemNode getPre() {
        return pre;
    }

    public void setPre(MemNode pre) {
        this.pre = pre;
    }

    public MemNode getNext() {
        return next;
    }

    public void setNext(MemNode next) {
        this.next = next;
    }
}
