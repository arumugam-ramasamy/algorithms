package com.evo.ib.disney.bt;

import com.evo.ib.tree.BinaryTree;
import com.evo.ib.tree.TreeNode;

public class PostOrderTraversal {
    public static void postOrder(TreeNode root) {
        if (root == null) return ;
        if (root.left != null) postOrder(root.left) ;
        if (root.right != null) postOrder(root.right);
        System.out.print(root.val + " ");
    }
    public static void main(String[] args) {
        int [] arr = {1, 3, 9, 2, 4, 5} ;
        TreeNode root = BinaryTree.arrayToBST(arr, 0, arr.length) ;
        BinaryTree bt = new BinaryTree() ;
        bt.printTree(root, null, false);
        postOrder(root);
        System.out.println();
    }
}
