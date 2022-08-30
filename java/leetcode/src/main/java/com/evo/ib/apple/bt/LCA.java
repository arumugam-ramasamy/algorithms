package com.evo.ib.apple.bt;

import com.evo.ib.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCA {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null) return q  ;
        if (q == null) return p ;
        if (root == null) return null ;
        List<TreeNode> list1 = new ArrayList<>() ;
        List <TreeNode> list2 = new ArrayList<>() ;
        boolean ans1 = findPath(root, p, list1)  ;
        boolean ans2 = findPath(root, q, list2) ;
        if (!(ans1 || ans2)) {
            System.out.println ("cannot find given nodes") ;
            return null ;
        }
        int i ;
        for (i = 0 ; i < list1.size() && i < list2.size() ; i++) {
            if (!(list1.get(i).val == list2.get(i).val)) break ;
        }

        return list1.get(i-1) ;
    }

    public static boolean findPath(TreeNode root, TreeNode p, List<TreeNode> list) {

        if (root == null) return false ;
        list.add(root) ;
        if (root.val == p.val) return true ;
        if (root.left != null && findPath(root.left, p, list)){
            return true;
        }
        if (root.right != null && findPath(root.right, p, list)) {
            return true;
        }
        list.remove(list.size()-1) ;
        return false ;
    }
}
