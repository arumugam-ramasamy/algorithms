package com.evo.ib.apple.bt;

import com.evo.ib.tree.TreeNode;

public class SameTrees {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q!= null) return false ;
        if (q == null && p!= null) return false ;
        if (p == null && q== null)  return true ;
        if (p.val != q.val) return false ;
        return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) ;
    }
}
