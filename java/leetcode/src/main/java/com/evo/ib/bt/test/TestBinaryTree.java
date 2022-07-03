package com.evo.ib.bt.test;

import com.evo.ib.tree.BinaryTree;
import com.evo.ib.tree.BinaryTreeHard;
import com.evo.ib.tree.TreeNode;

import java.util.Random;

public class TestBinaryTree {

    public static int [] generateRandomSortedArr(int total ) {
        int[] arr = new int[total] ;
        Random rand = new Random() ;

        for (int i = 0 ; i < total ; i++) {
            arr[i] = (rand.nextInt(10)  + i*10 );
        }
        return arr ;
    }

    public static void testBinaryTree() {
        int total = 15 ;
        int [] arr = generateRandomSortedArr(total) ;
        Random rand = new Random() ;
        TreeNode dps = new TreeNode(arr[rand.nextInt(total)])  ;
        TreeNode bfs = new TreeNode(arr[rand.nextInt(total)]) ;
        TreeNode node = BinaryTree.sortedArrayToBST  (arr, 0, total -1) ;
        BinaryTree tree = new BinaryTree() ;
        tree.setRoot(node);
        node = BinaryTree.sortedArrayToBST  (arr, 0, total -1) ;
        BinaryTree otherTree = new BinaryTree() ;
        otherTree.setRoot(node);

        System.out.println(tree.checkIdentical(otherTree) + " is this true");

       /* tree.insert(30);
        tree.insert(50);
        tree.insert(15);
        tree.insert(20);
        tree.insert(10);
        tree.insert(40);
        tree.insert(60);*/

        tree.printTree(tree.getRoot(), null, false);
        BinaryTreeHard bth = new BinaryTreeHard() ;
        System.out.println() ;
        System.out.println (bfs.val + " to be found") ;
        TreeNode find = bth.breadthFirstSearch(tree.getRoot(), bfs) ;
        if (find != null)
            System.out.println(find.val + " found") ;
        System.out.println(dps.val + " to be found");
        find = bth.depthFirstSearch(tree.getRoot(), dps) ;
        if (find != null)
            System.out.println (find.val + " found it " ) ;
        /*tree.printInOrder(tree.getRoot());
        System.out.println();
        tree.printInOrderLoop(tree.getRoot()) ;
        tree.printPreOrder(tree.getRoot());
        System.out.println();
        tree.printPostOrder(tree.getRoot());
        System.out.println();
        tree.printPreOrderLoop(tree.getRoot());
        System.out.println();
        System.out.println(tree.height(tree.getRoot())) ;*/

    }

    public static void main(String[] args) {
        testBinaryTree();
    }

}
