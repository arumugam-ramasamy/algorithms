package com.evo.ib.top.bt;

import com.evo.ib.tree.TreeNode;

import java.util.HashMap;

public class ConstructPreIn {
    static HashMap<Integer,Integer> mp = new HashMap<>();
    static int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length ;  i++)
        {
            mp.put(inorder[i], i);
        }
        return buildTreeRec(preorder, inorder, 0, inorder.length-1) ;
    }
    public TreeNode buildTreeRec(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null ;

        int cur = preorder[preIndex++] ;
        TreeNode node = new TreeNode(cur) ;
        if (start == end) return node ;

        int mindex = mp.get(cur) ;

        node.left = buildTreeRec(preorder, inorder, start, mindex-1) ;
        node.right = buildTreeRec(preorder, inorder, mindex+1, end) ;
        return node ;

    }

}
