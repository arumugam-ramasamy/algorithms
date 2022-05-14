package com.evo.ib.tree;

public class BinaryNode {
    int key;
    BinaryNode left ;
    BinaryNode right ;

    public BinaryNode(int key) {
        this.key = key ;
        this.left = null ;
        this.right = null ;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
