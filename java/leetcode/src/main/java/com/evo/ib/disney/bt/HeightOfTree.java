package com.evo.ib.disney.bt;

import com.evo.ib.tree.BinaryTree;
import com.evo.ib.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {
    public static int height(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
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
                TreeNode newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 2, 4, 5, 4, 9, 5, 8};
        TreeNode root = BinaryTree.arrayToBST(arr, 0, arr.length);
        BinaryTree bt = new BinaryTree();
        bt.printTree(root, null, false);
        System.out.println(height(root));
    }
}
