package com.evo.ib.bt;

public class RandomNode<T extends Comparable<?>> implements  Comparable {
    RandomNode<T> left, right;
    T data;

    public RandomNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RandomNode<T> getLeft() {
        return left;
    }

    public void setLeft(RandomNode<T> left) {
        this.left = left;
    }

    public RandomNode<T> getRight() {
        return right;
    }

    public void setRight(RandomNode<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(Object o) {
        RandomNode<T> od = (RandomNode<T>) o ;

        return  (this.getData().toString().compareTo( od.getData().toString())) ;
    }
}
