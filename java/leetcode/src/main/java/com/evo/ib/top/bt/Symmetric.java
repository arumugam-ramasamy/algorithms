package com.evo.ib.top.bt;

import com.evo.ib.tree.TreeNode;

public class Symmetric {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true ;

        return (checkMirror (root.left, root.right)) ;

    }

    public boolean checkMirror(TreeNode a, TreeNode b) {
        if (a == null && b ==null)  return true ;

        if (a == null || b == null) return false ;

        return (a.val == b.val && (checkMirror(a.left, b.right) && checkMirror(a.right, b.left))) ;
    }
}
