package com.smic.practice.btree;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by PranavsMac on 9/29/20.
 */
public class BinaryTree  {

    Node<Integer>  root ;

    BinaryTree () {
        root = null ;
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> root) {
        this.root = root;
    }

    public void insert (int data) {

        Node< Integer> node = getRoot() ;

        if (node == null) {
            setRoot(createNode(data));
            return ;
        }
        Boolean insert = false ;
        while (insert == false){
            if (node.data < data) {
                if (node.getRight() == null) {
                    node.setRight(createNode(data));
                    insert = true ;
                    break ;
                }
                else {
                    node = node.getRight() ;
                }
            }
            else  {
                if (node.getLeft() == null) {
                    node.setLeft(createNode(data));
                    insert = true ;
                    break ;
                }
                else {
                    node = node.getLeft() ;
                }
            }
        }
    }

    public void getVectorData (Node<Integer>  node, Vector<Node<Integer>> vec) {

        if (node == null) return  ;
        getVectorData(node.getLeft(), vec);
        vec.add(node) ;
        getVectorData(node.getRight(), vec);

    }

    public Node<Integer> buildBinaryTree (Vector<Node<Integer>> vec, int start, int end) {

        if (start > end ) return null ;
        int mid = (end + start) / 2 ;
        Node<Integer> node = vec.get(mid) ;
        node.setLeft(buildBinaryTree(vec, start, mid-1));
        node.setRight(buildBinaryTree(vec, mid+1, end));
        return node ;

    }


    public void balanceBST () {

        Vector<Node<Integer>> data = new Vector<>() ;
        getVectorData(getRoot(), data);
        setRoot(buildBinaryTree(data, 0, data.size()-1)) ;

    }

    public Node createNode (int data) {

        Node<Integer> node = new Node<>(data) ;
        node.setLeft(null);
        node.setRight(null);
        return node ;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree() ;
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        bt.insert(6);
        bt.insert(7);
        bt.insert(8);
        BTreePrinter.printNode(bt.getRoot());
        bt.balanceBST();
        BTreePrinter.printNode(bt.getRoot());
        bt.printInOrder();
        bt.printPostOrder();
        bt.printPreOrder();
    }

    public void printInOrder () {
        inOrderRec(getRoot());
        System.out.println();
        inOrderIter(getRoot());
        System.out.println();
    }

    public void inOrderRec(Node<Integer> node ) {

        if (node == null) return ;
        inOrderRec(node.getLeft());
        System.out.print (node.getData() + " ") ;
        inOrderRec(node.getRight());

    }

    public List<Integer> postOrder1Stack (Node<Integer> node) {
        if (node == null) return null ;
        List<Integer> list = new ArrayList<>() ;
        Stack<Node<Integer>> stack = new Stack<>() ;
        stack.push(node) ;
        Node<Integer> prev = null ;

        while (stack.size() > 0) {
            Node<Integer> cur = stack.peek() ;
            if (prev == null || prev.getLeft() == cur   ||
                    prev.getRight() == cur) {
                if (cur.getLeft() != null) {
                    stack.push(cur.getLeft()) ;
                }
                else if (cur.getRight() != null) {
                    stack.push(cur.getRight()) ;
                }
                else {
                    stack.pop() ;
                    list.add(cur.getData()) ;
                }
            }
            else if (cur.getLeft() == prev) {
                if (cur.getRight() != null) {
                    stack.push(cur.getRight()) ;
                }
                else {
                    stack.pop() ;
                    list.add(cur.getData()) ;
                }
            }
            else if (cur.getRight() == prev) {
                stack.pop() ;
                list.add(cur.getData()) ;
            }

            prev = cur ;

        }
        return list ;

    }

    public boolean nodeExists (Node tofind) {
        Node node = getRoot() ;
        if (node == null)  return  false ;
        boolean found = false ;
        while (node != null) {
            if (node.getData() == tofind.getData()) return true ;
            int res = node.compareTo(tofind) ;
            if (res == 0) {
                return true ;
            }
            if (res > 0) node = node.getLeft() ;
            if (res < 0) node = node.getRight() ;
        }
        return found  ;
    }

    public Node commonAncestor (Node a, Node b) {
        Node node = getRoot() ;
        if (node == null) return null ;
        if (a == null || b == null)  return null ;
        if (nodeExists(a) == false || nodeExists(b) == false) return null ;
        while (node != null) {
            if (a.getData() == node.getData() || b.getData() == node.getData()) {
                return node;
            }
            if ((a.compareTo(node) < 0 && b.compareTo(node) > 0) ||
                    (a.compareTo(node) > 0 && b.compareTo(node) < 0)) {
                return node;
            }
            if (a.compareTo(node) < 0 && b.compareTo(node) < 0) node = node.getLeft();
            if (a.compareTo(node) > 0 && b.compareTo(node) > 0) node = node.getRight();
        }
        return null ;
    }

    public void printPostOrder () {
        postOrderRec(getRoot());
        System.out.println();
        postOrderIter(getRoot());
        System.out.println();
        List<Integer> list = postOrder1Stack(getRoot()) ;
        for (Integer val : list) {
            System.out.print(val + " ") ;
        }
        System.out.println();
    }

    public void postOrderRec(Node<Integer> node ) {
        if (node == null) return ;
        postOrderRec(node.getLeft());
        postOrderRec(node.getRight());
        System.out.print (node.getData() + " ") ;
    }

    public void printPreOrder () {
        preOrderRec(getRoot());
        System.out.println();
        preOrderIter(getRoot());
        System.out.println();
    }

    public void preOrderRec(Node<Integer> node ) {
        if (node == null) return ;
        System.out.print (node.getData() + " ") ;
        preOrderRec(node.getLeft());
        preOrderRec(node.getRight());
    }

    public void preOrderIter (Node<Integer> node){
        if (node == null) return;
        Stack<Node<Integer>> stack = new Stack<>() ;
        stack.push(node) ;

        while (stack.size() != 0) {
            Node<Integer> cur = stack.pop() ;
            System.out.print(cur.getData() + " ");
            if (cur.getRight() != null) stack.push(cur.getRight()) ;
            if (cur.getLeft() != null) stack.push(cur.getLeft()) ;
        }
    }

    public void inOrderIter (Node<Integer> node){
        if (node == null) return;
        Stack<Node<Integer>> stack = new Stack<>() ;
        Node <Integer> cur = node ;

        while (cur != null || stack.size() != 0) {
            while (cur != null) {
                stack.push(cur) ;
                cur = cur.getLeft() ;
            }
            cur = stack.pop() ;
            System.out.print (cur.getData() + " ");
            cur = cur.getRight() ;
        }
    }

    public void postOrderIter (Node<Integer> node){
        if (node == null) return;
        Stack<Node<Integer>> stack = new Stack<>() ;
        Stack<Node<Integer>> poststack = new Stack<>() ;
        stack.push (node) ;

        while (stack.size() > 0) {
            Node<Integer> cur = stack.pop() ;
            poststack.push(cur) ;
            if (cur.getLeft() != null) stack.push(cur.getLeft()) ;
            if (cur.getRight() != null)  stack.push(cur.getRight()) ;
        }

       while (poststack.size()> 0) {
           System.out.print (poststack.pop().getData() + " ") ;
       }
    }

}
