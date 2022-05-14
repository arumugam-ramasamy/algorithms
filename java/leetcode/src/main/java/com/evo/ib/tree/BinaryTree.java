package com.evo.ib.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {


    static final int COUNT = 10;

    BinaryNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to
       insert a new key in BST */
    BinaryNode insertRec(BinaryNode root, int key) {

        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new BinaryNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // print left child, parent, right child  (recursion)
    public void printInOrder(BinaryNode root) {
        if (root != null) printInOrder(root.getLeft());
        else return;
        System.out.print(root.getKey() + " ");
        if (root != null) printInOrder(root.getRight());
        else return;

    }

    // print left child, parent, right child (loop)
    public void printInOrderLoop(BinaryNode root) {
        if (root == null) return;
        Stack<BinaryNode> st = new Stack<>();

        BinaryNode curr = root;

        while (curr != null || st.size() > 0) {

            while (curr != null) {
                st.push(curr);
                curr = curr.getLeft();
            }
            curr = st.pop();
            System.out.print(curr.getKey() + " ");
            curr = curr.getRight();
        }
        System.out.println();
    }

    public void printPostOrder(BinaryNode root) {
        if (root != null) {
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
        } else return;
        System.out.print(root.getKey() + " ");
    }

    // parent first, left then right child (recursion)
    public void printPreOrder(BinaryNode root) {
        if (root != null) {
            System.out.print(root.getKey() + " ");
        } else return;
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
    }

    // parent first, left then right child (loop)
    public void printPreOrderLoop(BinaryNode root) {

        Stack<BinaryNode> st = new Stack<>();

        if (root == null) {
            return;
        }


        // Start from root node (set curr
        // node to root node)
        BinaryNode curr = root;

        // Run till stack is not empty or
        // current is not NULL
        while (curr != null || !st.isEmpty()) {

            // Print left children while exist
            // and keep pushing right into the
            // stack.
            while (curr != null) {
                System.out.print(curr.getKey() + " ");

                if (curr.right != null)
                    st.push(curr.getRight());

                curr = curr.left;
            }

            // We reach when curr is NULL, so We
            // take out a right child from stack
            if (!st.isEmpty()) {
                curr = st.pop();
            }
        }

    }

    public static void showTrunks(Trunk p) {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

    public void printTree(BinaryNode root, Trunk prev, boolean isLeft) {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.right, trunk, true);

        if (prev == null) {
            trunk.str = "———";
        } else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        } else {
            trunk.str = "`———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.getKey());

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.left, trunk, false);
    }


    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public int height(BinaryNode root) {
        if (root == null) return 0;
        Queue<BinaryNode> q = new LinkedList<>();
        int height = 0;
        q.add(root);
        int nodecount = q.size();

        while (1 == 1) {
            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {
                BinaryNode newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }

    }


}
