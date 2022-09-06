package com.evo.ib.top.bt;

import com.evo.ib.tree.BinaryTree;
import com.evo.ib.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        boolean valid = false ;

        valid  = checkValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE) ;

        return valid ;
    }

    boolean checkValidBST (TreeNode node, long minValue, long maxValue) {
        if (node == null) return true ;
        Queue<Long> minMax = new LinkedList<>() ;
        Queue<TreeNode> nodes = new LinkedList<>() ;
        if (node.val < minValue || node.val > maxValue) return false ;
        if (node.left != null) {
            nodes.add(node.left) ;
            minMax.add( minValue) ;
            minMax.add((long)node.val-1) ;
        }
        if (node.right != null) {
            nodes.add(node.right) ;
            minMax.add((long)node.val+1) ;
            minMax.add(maxValue) ;
        }

        int currentsize = nodes.size();
        int nextsize = 0 ;

        while (nodes.size() > 0) {

            while (currentsize > 0) {
                TreeNode cur = nodes.remove() ;
                long min = minMax.remove() ;
                long max = minMax.remove() ;
                if (cur.val < min || cur.val > max ) return false ;
                --currentsize ;
                if (cur.left != null) {
                    minMax.add(min) ;
                    minMax.add((long)cur.val-1) ;
                    nodes.add(cur.left );
                    ++nextsize ;
                }
                if (cur.right != null) {
                    minMax.add((long)cur.val+1) ;
                    minMax.add(max) ;
                    nodes.add(cur.right);
                    ++nextsize ;
                }
            }
            currentsize = nextsize ;
            nextsize = 0 ;

        }
        return true ;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2};
        BinaryTree tree = new BinaryTree();
        TreeNode node = BinaryTree.arrayToBST(arr, 0, arr.length);
        tree.printTree(node, null, false);
        ValidateBST validateBST = new ValidateBST() ;
        System.out.println (validateBST.isValidBST(node) ) ;
    }
}
