package com.evo.ib.ebay.bt;


import com.evo.ib.bt.BinaryTree;
import com.evo.ib.tree.TreeNode;

import java.util.*;

public class BottomView {

    public static List<Integer> bottomView (TreeNode tree){
        List <Integer> list = new ArrayList<>() ;
        Map<Integer, List<Integer>> bottomView = new HashMap<>() ;
        if (tree == null) return null ;
        Map <Integer, List<Integer>> btView = new HashMap<>() ;
        List<Integer> valSet = new ArrayList<>() ;
        valSet.add(tree.val) ;
        btView.put(0, valSet)  ;
        Queue<TreeNode> treelist = new LinkedList<>() ;
        treelist.add(tree) ;

        return list ;
    }
}
