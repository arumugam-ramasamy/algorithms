package com.smic.practice.btree;

class Node<T extends Comparable<?>> implements  Comparable {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(Object o) {
         Node<T> od = (Node <T>) o ;

        return  (this.getData().toString().compareTo( od.getData().toString())) ;
    }
}
