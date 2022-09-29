package com.evo.ib.ebay.bt;


import com.evo.ib.bt.BinaryTree;
import com.evo.ib.tree.TreeNode;

import java.util.*;

public class BottomView {

    public static List<Integer> bottomView (TreeNode tree){
       if (tree == null) return null ;
       Map <Integer, List<Integer>> bottomMap = new HashMap<>() ;
       getBottomView(tree, 0, bottomMap) ;
        return null ;
    }

    public static void getBottomView(TreeNode root,   int mapIndex, Map<Integer, List<Integer>> btView) {
        if (root == null) return ;
        if (btView.containsKey(mapIndex)) {
            List<Integer> curList = btView.get(mapIndex) ;
            curList.add(root.val) ;
            btView.put(mapIndex, curList) ;
        }
        else {
            List<Integer> valList = new ArrayList<>() ;
            valList.add(root.val) ;
            btView.put(mapIndex, valList) ;
        }
        if (root.left != null) getBottomView(root.left, mapIndex-1, btView);
        if (root.right != null) getBottomView(root.right, mapIndex+1, btView);
    }
}
