package com.evo.ib.disney.bt;


import com.evo.ib.tree.BinaryTree;
import com.evo.ib.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public static List<Integer> inOrderTraversalLoop(TreeNode root) {
        if (root == null) return null ;
        List<Integer> inorder = new ArrayList<>() ;
        Stack<TreeNode> stack = new Stack<>() ;
        TreeNode cur = root ;

        while (cur != null || stack.size() > 0) {
            while (cur != null) {
                stack.push(cur) ;
                cur = cur.left ;
            }
            cur = stack.pop() ;
            if (cur != null) {
                inorder.add(cur.val);
                cur = cur.right;
            }
        }
        return inorder ;
    }

    public static List<Integer> preOrderTraversal (TreeNode root) {
        if (root  == null) return null ;
        TreeNode cur = root ;
        Stack<TreeNode> stack = new Stack<>() ;
        List<Integer> preOrder = new ArrayList<>() ;

        while (cur != null || stack.size() > 0) {
            while (cur != null) {
                preOrder.add(cur.val) ;
                if (cur.right != null)
                    stack.push(cur.right) ;
                cur = cur.left ;
            }
            if (!stack.empty()) {
                cur = stack.pop() ;
            }
        }
        return preOrder ;
    }

    public static void main(String[] args) {
        int [] arr = {1, 3, 9, 2, 4, 5} ;
        TreeNode root = BinaryTree.arrayToBST(arr, 0, arr.length) ;
        BinaryTree bt = new BinaryTree() ;
        bt.printTree(root, null, false);
        System.out.println(inOrderTraversalLoop(root));
        System.out.println(preOrderTraversal(root));
    }
}
