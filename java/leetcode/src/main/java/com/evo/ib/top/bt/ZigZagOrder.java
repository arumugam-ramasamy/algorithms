package com.evo.ib.top.bt;

import com.evo.ib.tree.TreeNode;

import java.util.*;

public class ZigZagOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root );
        boolean zigzag = true ;
        int levelcount = queue.size() ;
        int nextlevelcount = 0 ;

        while (levelcount > 0) {
            Stack<TreeNode> stack = new Stack<>() ;
            List<Integer> llist = new ArrayList<>() ;
            while (levelcount > 0) {
                TreeNode node = queue.remove() ;
                if (node != null) {
                    llist.add(node.val) ;
                    --levelcount ;
                }
                if (zigzag) {
                    if (node.left != null) {
                        stack.push(node.left);
                        ++nextlevelcount;
                    }
                    if (node.right != null) {
                        stack.push(node.right) ;
                        ++nextlevelcount ;
                    }
                }
                else {
                    if (node.right != null) {
                        stack.push(node.right);
                        ++nextlevelcount;
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                        ++nextlevelcount;
                    }
                }


            }
            while(stack.size() > 0) {
                queue.add(stack.pop()) ;
            }
            levelcount = nextlevelcount ;
            zigzag = !zigzag ;
            nextlevelcount = 0 ;
            list.add(llist) ;

        }
        return list ;

    }
}
