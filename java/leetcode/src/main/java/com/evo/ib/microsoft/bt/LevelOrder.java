package com.evo.ib.microsoft.bt;

import com.evo.ib.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelcount = queue.size();
        int nextlevelcount = 0;

        while (levelcount > 0) {
            List<Integer> llist = new ArrayList<>();
            while (levelcount > 0) {
                TreeNode node = queue.remove();
                if (node != null) {
                    llist.add(node.val);
                    --levelcount;
                }

                if (node.left != null) {
                    queue.add(node.left);
                    ++nextlevelcount;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    ++nextlevelcount;

                }


            }
            levelcount = nextlevelcount;
            nextlevelcount = 0;
            list.add(llist);

        }
        return list;
    }
}
