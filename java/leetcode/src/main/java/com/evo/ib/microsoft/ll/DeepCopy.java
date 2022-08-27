package com.evo.ib.microsoft.ll;

import com.evo.ib.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.



Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]


Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.
   Hide Hint #1
Just iterate the linked list and create copies of the nodes on the go. Since a node can be referenced from multiple nodes due to the random pointers, make sure you are not making multiple copies of the same node.
   Hide Hint #2
You may want to use extra space to keep old node ---> new node mapping to prevent creating multiples copies of same node.
   Hide Hint #3
We can avoid using extra space for old node ---> new node mapping, by tweaking the original linked list. Simply interweave the nodes of the old and copied list. For e.g.
Old List: A --> B --> C --> D
InterWeaved List: A --> A' --> B --> B' --> C --> C' --> D --> D'
   Hide Hint #4
The interweaving is done using next pointers and we can make use of interweaved structure to get the correct reference nodes for random pointers.
 */
public class DeepCopy {

    public Node copyRandomList(Node head) {
        Node newHead = null;
        Node newCur;
        Map<Node, Node> arbitray = new HashMap<>();
        if (head == null) return null;

        newCur = head;
        Node prev = null;
        while (newCur != null) {
            Node temp = new Node();
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
    Node head = null;
    Node cur = null;


    public void insertNode(int data) {
        Node listNode = new Node();
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

}
