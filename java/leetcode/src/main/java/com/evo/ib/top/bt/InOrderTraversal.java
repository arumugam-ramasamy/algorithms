package com.evo.ib.top.bt;

import com.evo.ib.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>() ;
        if (root == null) return inorder ;

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
}

