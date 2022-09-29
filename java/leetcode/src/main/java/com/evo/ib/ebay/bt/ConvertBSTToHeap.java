package com.evo.ib.ebay.bt;

import com.evo.ib.tree.BinaryTree;
import com.evo.ib.tree.TreeNode;

import java.util.*;

public class ConvertBSTToHeap {

    public static TreeNode convertBSTToHeap (TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root ;
        List<Integer> list = inOrderLoop(root) ;
        return (convertListToHeap(list)) ;
    }

    public static TreeNode convertListToHeap (List<Integer> intList) {

        if (intList == null) return  null ;

        TreeNode root = new TreeNode(intList.get(0)) ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;

        int count = 1 ;
        int curLevel = queue.size() ;
        int nextLevel = 0 ;
        while (count < intList.size()  && queue.size() > 0) {
            while (curLevel > 0) {
                TreeNode node = queue.remove();
                --curLevel;
                if (count >= intList.size()) break ;
                node.left = new TreeNode(intList.get(count)) ;
                ++count ;
                queue.add(node.left) ;
                ++nextLevel ;
                if (count >= intList.size()) break ;
                node.right = new TreeNode(intList.get(count)) ;
                ++count ;
                queue.add(node.right) ;
                ++nextLevel ;
            }
            curLevel = nextLevel ;
            nextLevel = 0 ;

        }
        return  root ;
    }

    public static List<Integer> inOrderLoop(TreeNode root) {
        if (root == null) return null ;
        List<Integer> list = new ArrayList<>() ;
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while (curr != null || st.size() > 0) {

            while (curr != null) {
                st.push(curr);
                curr = curr.getLeft();
            }
            curr = st.pop();
            list.add(curr.getVal()) ;
            curr = curr.getRight();
        }
        return list ;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4, 5, 6, 7, 8,9,10, 11};
        BinaryTree tree = new BinaryTree();
        TreeNode node = BinaryTree.sortedArrayToBST(arr, 0, arr.length-1);
        tree.printTree(node, null, false);
        TreeNode newroot = convertBSTToHeap(node) ;
        tree.printTree(newroot, null, false);
    }

}
