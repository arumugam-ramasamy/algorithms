package com.evo.ib.microsoft.bt;

import com.evo.ib.tree.BinaryTree;
import com.evo.ib.tree.TreeNode;

public class ValidateBST {
    public static  boolean isValidBST(TreeNode root) {
        if (root == null) return true ;
        return isValidBST (root, Long.MIN_VALUE, Long.MAX_VALUE) ;
    }

    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true ;
        if (root.val < min || root.val > max) return false ;
        //System.out.println (root.val + " " + min + " " + max) ;
        return (isValidBST(root.left, min, (long) root.val -1L) &&
                isValidBST(root.right, (long)root.val+1L, max)) ;
    }

    public static void main(String[] args) {
        int [] arr = {1, 3, 9, 2, 4, 5} ;
        TreeNode root = BinaryTree.arrayToBST(arr, 0, arr.length) ;
        BinaryTree bt = new BinaryTree() ;
        bt.printTree(root, null, false);
        System.out.print(isValidBST(root));
    }
}
