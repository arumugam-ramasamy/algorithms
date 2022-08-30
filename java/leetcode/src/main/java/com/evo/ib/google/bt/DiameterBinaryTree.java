package com.evo.ib.google.bt;

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */

import com.evo.ib.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterBinaryTree {
    public static  int diameterOfBinaryTree(TreeNode root) {

        int lheight = height( root.left ) ;
        int rheight = height(root.right) ;

        int ldiameter = diameterOfBinaryTree(root.left) ;
        int rdiameter = diameterOfBinaryTree(root.right) ;

        return (Math.max(1+rheight+lheight, Math.max(ldiameter, rdiameter))) ;

    }

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


}
