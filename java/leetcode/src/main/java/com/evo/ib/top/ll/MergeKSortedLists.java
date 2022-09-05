package com.evo.ib.top.ll;

import com.evo.ib.linkedlist.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
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

    public ListNode mergeKLists(ListNode[] lists) {

        // Comparator<LinkedCompare> dataSorter = Comparator.comparing(LinkedCompare::getData);
        Queue<LinkedCompare> priorityQueue = new PriorityQueue<>();
        for (int i = 0 ; i < lists.length ; i++) {
            if (lists[i] != null )
                priorityQueue.add(new LinkedCompare(lists[i].val, i)) ;
        }
        ListNode headMerged = null ;
        ListNode curMerged = headMerged ;
        LinkedCompare curQueue = priorityQueue.poll() ;

        while (curQueue != null) {
            ListNode curNode = lists[curQueue.getInd()] ;
            if (headMerged == null) {
                headMerged = curNode ;
                curMerged = headMerged ;
            }
            else {
                curMerged.next = curNode;
                curMerged = curMerged.next ;
            }
            curNode = curNode.next;
            lists[curQueue.getInd()] = curNode ;
            if (curNode != null)
                priorityQueue.add(new LinkedCompare(curNode.val, curQueue.getInd())) ;
            curQueue = priorityQueue.poll() ;
        }
        if (curMerged != null)
            curMerged.next = null;
        return headMerged ;
    }
}
