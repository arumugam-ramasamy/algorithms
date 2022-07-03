package com.evo.ib.google;

import com.evo.ib.linkedlist.NewListNode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListProblems {
        NewListNode head;
        NewListNode cur;

        public LinkedListProblems() {
                head = cur = null;
        }

        public void insertNode(int data) {
                NewListNode listNode = new NewListNode();
                listNode.setVal(data);
                listNode.setNext(null);
                listNode.setArbitrary(null);
                if (head == null) {
                        head = listNode;
                        cur = head;
                        return;
                }
                cur.setNext(listNode);
                cur = cur.getNext();
        }

        public NewListNode getHead() {
                return head;
        }

        public void setHead(NewListNode head) {
                this.head = head;
        }

        public NewListNode getCur() {
                return cur;
        }

        public void setCur(NewListNode cur) {
                this.cur = cur;
        }

        public NewListNode deepCopy() {
                NewListNode newHead = null;
                NewListNode newCur;
                Map<NewListNode, NewListNode> arbitray = new HashMap<>();
                if (getHead() == null) return null;

                newCur = getHead();
                NewListNode prev = null;
                while (newCur != null) {
                        NewListNode temp = new NewListNode();
                        temp.setVal(newCur.getVal());
                        temp.setArbitrary(newCur.getArbitrary());
                        if (prev == null) {
                                newHead = temp;
                        } else {
                                prev.setNext(temp);
                        }

                        arbitray.put(newCur, temp);
                        prev = temp;
                        newCur = newCur.getNext();

                }

                newCur = newHead;

                while (newCur != null) {
                        if (newCur.getArbitrary() != null) {
                                newCur.setArbitrary(arbitray.get(newCur.getArbitrary()));
                        }
                        newCur= newCur.getNext() ;
                }


                return newHead;
        }

        public void printll(NewListNode p) {
                while (p != null) {
                        System.out.print(p.getVal());
                        if (p.getArbitrary() != null) {
                                System.out.print(" , arbirary = " + p.getArbitrary().getVal() + " ");
                        }
                        System.out.print("--->") ;
                        p = p.getNext();
                }
                System.out.println("null");
        }
}
