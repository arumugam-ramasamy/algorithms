package com.evo.ib.google.linkedlist;

import com.evo.ib.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

public class LinkedListProblems {
        Node head;
        Node cur;

        public LinkedListProblems() {
                head = cur = null;
        }

        public void insertNode(int data) {
                Node listNode = new Node();
                listNode.setVal(data);
                listNode.setNext(null);
                listNode.setRandom(null);
                if (head == null) {
                        head = listNode;
                        cur = head;
                        return;
                }
                cur.setNext(listNode);
                cur = cur.getNext();
        }

        public Node getHead() {
                return head;
        }

        public void setHead(Node head) {
                this.head = head;
        }

        public Node getCur() {
                return cur;
        }

        public void setCur(Node cur) {
                this.cur = cur;
        }

        public Node deepCopy() {
                Node newHead = null;
                Node newCur;
                Map<Node, Node> arbitray = new HashMap<>();
                if (getHead() == null) return null;

                newCur = getHead();
                Node prev = null;
                while (newCur != null) {
                        Node temp = new Node();
                        temp.setVal(newCur.getVal());
                        temp.setRandom(newCur.getRandom());
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
                        if (newCur.getRandom() != null) {
                                newCur.setRandom(arbitray.get(newCur.getRandom()));
                        }
                        newCur= newCur.getNext() ;
                }


                return newHead;
        }

        public void printll(Node p) {
                while (p != null) {
                        System.out.print(p.getVal());
                        if (p.getRandom() != null) {
                                System.out.print(" , arbirary = " + p.getRandom().getVal() + " ");
                        }
                        System.out.print("--->") ;
                        p = p.getNext();
                }
                System.out.println("null");
        }
}
