package com.evo.ib.top.ll;

import com.evo.ib.top.ll.RandomNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public RandomNode copyRandomList(RandomNode head) {
        RandomNode newHead = null;
        RandomNode newCur;
        Map<RandomNode, RandomNode> arbitray = new HashMap<>();
        if (head == null) return null;

        newCur = head;
        RandomNode prev = null;
        while (newCur != null) {
            RandomNode temp = new RandomNode(1);
            temp.val = newCur.val;
            temp.random = newCur.random;
            if (prev == null) {
                newHead = temp;
            } else {
                prev.next = temp;
            }

            arbitray.put(newCur, temp);
            prev = temp;
            newCur = newCur.next;

        }

        newCur = newHead;

        while (newCur != null) {
            if (newCur.random != null) {
                newCur.random  = arbitray.get(newCur.random) ;
            }
            newCur= newCur.next ;
        }


        return newHead;
    }
    RandomNode head = null;
    RandomNode cur = null;


    public void insertNode(int data) {
        RandomNode listNode = new RandomNode(1);
        listNode.val = data;
        listNode.next = null;
        listNode.random = null;
        if (head == null) {
            head = listNode;
            cur = head;
            return;
        }
        cur.next = listNode ;
        cur = cur.next;
    }

    public RandomNode getHead() {
        return head;
    }

    public void setHead(RandomNode head) {
        this.head = head;
    }

    public RandomNode getCur() {
        return cur;
    }

    public void setCur(RandomNode cur) {
        this.cur = cur;
    }

}
