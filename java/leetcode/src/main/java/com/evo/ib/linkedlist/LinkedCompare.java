package com.evo.ib.linkedlist;

public class LinkedCompare implements Comparable<LinkedCompare> {
    int data ;
    int ind ;

    public LinkedCompare (int data, int ind) {
        this.data = data ;
        this.ind = ind ;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    @Override
    public int compareTo(LinkedCompare newll) {
        return (this.getData() - newll.getData())  ;
    }
}
