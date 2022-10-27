package com.evo.ib.recursion;

import com.evo.ib.tree.BinaryTree;
import com.evo.ib.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ValidBST {

    public static boolean validBST (TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ;
    }

    public static boolean isValidBST (TreeNode root, int min, int max) {
        if (root == null) return true ;
        if (root.val < min || root.val > max) return false ;
        return (isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val+1, max)) ;
    }

    /* A function that constructs Balanced Binary Search Tree
    from a sorted array */
    public static TreeNode sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }


    public static void main(String[] args) {
        int [] arr = {-10,9,20, -111, -111,15,7} ;
        BinaryTree tree = new BinaryTree()  ;
        TreeNode node = arrayToBST(arr, 0, arr.length) ;
        tree.printTree(node, null, false);
        System.out.println (validBST(node) );
        Arrays.sort(arr);
        node = sortedArrayToBST(arr, 0, arr.length-1) ;
        tree.printTree(node, null, false);
        System.out.println (validBST(node) );

    }

    public static TreeNode arrayToBST(int[] arr, int start, int end) {

        TreeNode node = new TreeNode(arr[0]);
        Queue<TreeNode> tree = new LinkedList<>() ;
        tree.add(node) ;

        int ind = 1 ;
        while (tree.size() > 0) {
            TreeNode cur = tree.remove() ;
            if (ind >= arr.length) break ;
            Integer val = arr[ind] ;
            if (val != -111) {
                TreeNode ins = new TreeNode(arr[ind]) ;
                cur.left = ins  ;
                tree.add(ins) ;
            }
            else {
                cur.left = null ;
            }
            ind++ ;
            if (ind >= arr.length) break ;
            val = arr[ind] ;
            if (val != -111) {
                TreeNode ins = new TreeNode(arr[ind]) ;
                cur.right = ins  ;
                tree.add(ins) ;
            }
            else {
                cur.right = null ;
            }
            ind++ ;
        }
        return node;
    }

}
