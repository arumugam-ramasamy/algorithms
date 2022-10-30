package com.evo.ib.proofpoint;

import com.evo.ib.tree.TreeNode;


import java.util.LinkedList;
import java.util.Queue;

public class TreePathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null && targetSum == 0) return true ;
        if (root == null) return false ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        int cursize = 0 ;
        while (queue.size() > 0) {
            TreeNode node = queue.remove() ;
            if (node.val == targetSum && isChild(node)) return true ;
            if (node.left != null) {
                TreeNode left = node.left ;
                left.val = left.val + node.val ;
                queue.add(left) ;
            }
            if (node.right != null) {
                TreeNode right = node.right ;
                right.val = right.val + node.val ;
                queue.add(right) ;
            }
        }
        return false ;
    }

    public static boolean isChild (TreeNode node) {
        if (node.left == null && node.right == null) return true ;
        return  false ;
    }

}
