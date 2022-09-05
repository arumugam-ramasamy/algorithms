package com.evo.ib.top.bt;

import com.evo.ib.google.bt.MaximumPath;
import com.evo.ib.tree.BinaryTree;
import com.evo.ib.tree.TreeNode;

public class InOrderSuccessor {
    public TreeNode inOrderSccc (TreeNode root, TreeNode p) {
        if (p.right != null)
            return minNode(p.right) ;
        TreeNode succ = null ;

        while (root != null) {
            if (p.val < root.val){
                succ = root ;
                root = root.left ;
            }
            else if (p.val > root.val) {
                root = root.right;
            } else
                break;

        }
        if (root != null && root.val > p.val && root.val < succ.val) {
            succ=root ;
        }
        return succ ;
    }
    public TreeNode minNode(TreeNode r) {
        if (r.left != null)
            r = r.left ;
        return r ;
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 3};
        BinaryTree tree = new BinaryTree();
        TreeNode node = BinaryTree.arrayToBST(arr, 0, arr.length);
        tree.printTree(node, null, false);
        InOrderSuccessor inOrderSuccessor = new InOrderSuccessor() ;
        System.out.println (inOrderSuccessor.inOrderSccc(node, node.left).val ) ;
    }

}
