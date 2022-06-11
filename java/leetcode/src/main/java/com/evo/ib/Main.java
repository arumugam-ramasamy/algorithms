package com.evo.ib;


import com.evo.ib.arrays.ArrayProblems;
import com.evo.ib.graph.EasyProblems;
import com.evo.ib.linkedlist.LinkedCompare;
import com.evo.ib.linkedlist.LinkedList;
import com.evo.ib.linkedlist.ListNode;
import com.evo.ib.math.Fibonacci;
import com.evo.ib.sort.MergeSort;
import com.evo.ib.strings.StringHardProblems;
import com.evo.ib.tree.BinaryTreeHard;
import com.evo.ib.tree.TreeNode;
import com.evo.ib.tree.BinaryTree;

import java.util.*;

public class Main {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2 ;
        if (l2 == null) return l1 ;

        int sum ;
        int carry = 0 ;
        ListNode prev = null ;
        ListNode head = l1 ;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry ;
            if (sum >= 10) {
                carry = sum / 10 ;
                sum = sum % 10 ;

            }
            else carry = 0 ;
            l1.val = sum ;
            prev = l1 ;
            l1 = l1.next ;
            l2 = l2.next ;
        }

        if (l1 == null && l2 != null) {
            prev.next = l2 ;
            l1 = l2 ;
            while (l1 != null) {
                sum = carry + l1.val ;
                if (sum >= 10) {
                    carry = sum / 10 ;
                    sum = sum % 10 ;

                }
                else carry = 0 ;
                l1.val = sum ;
                prev = l1 ;
                l1 = l1.next ;
            }

        }

        if (l1 != null && l2 == null) {
            while (l1 != null) {
                sum = carry + l1.val ;
                if (sum >= 10) {
                    carry = sum / 10 ;
                    sum = sum % 10 ;

                }
                else carry = 0 ;
                prev = l1 ;
                l1.val = sum ;
                l1 = l1.next ;
            }
        }
        if (carry > 0) {
            l1 = new ListNode () ;
            l1.val = carry ;
            prev.next = l1 ;
        }
        return head ;
    }

    public static ListNode mergeKLinkedList (List<ListNode> lls){
        Comparator<LinkedCompare> dataSorter = Comparator.comparing(LinkedCompare::getData);
        Queue<LinkedCompare> priorityQueue = new PriorityQueue<>(dataSorter);
        for (int i = 0 ; i < lls.size() ; i++) {
            priorityQueue.add(new LinkedCompare(lls.get(i).getVal(), i)) ;
        }
        ListNode headMerged = null ;
        ListNode curMerged = headMerged ;
       LinkedCompare curQueue = priorityQueue.poll() ;

        while (curQueue != null) {
            ListNode curNode = lls.get(curQueue.getInd()) ;
            if (headMerged == null) {
                headMerged = curNode ;
                curMerged = headMerged ;
            }
            else {
                curMerged.setNext(curNode);
                curMerged = curMerged.getNext() ;
            }
            curNode = curNode.getNext() ;
            lls.set(curQueue.getInd(), curNode)  ;
            if (curNode != null)
                priorityQueue.add(new LinkedCompare(curNode.getVal(), curQueue.getInd())) ;
            curQueue = priorityQueue.poll() ;
        }
        curMerged.setNext(null);
        return headMerged ;
    }

    public static void testMergeLinkedList() {
        Random rand = new Random() ;
        int upperbound = 100 ;
        List<ListNode> arrList = new ArrayList<>() ;
        LinkedList ll = new LinkedList() ;
        int count = rand.nextInt(10) + 1 ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            ll.insertNode(val) ;
        }
        ll.printll(ll.getHead());
        arrList.add(ll.getHead()) ;
        LinkedList l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        arrList.add(l2.getHead()) ;
        l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        arrList.add(l2.getHead()) ;
        l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        arrList.add(l2.getHead()) ;
        l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        arrList.add(l2.getHead()) ;
        l2.printll(mergeKLinkedList(arrList))  ;
    }
    public static void testRemoveDuplicates () {
        List <Integer> arr = new ArrayList<>() ;
        Random rand = new Random() ;
        int prov = 0 ;
        int upperbound =5 ;
        for (int i = 0 ; i < 100 ; i++) {
            if (rand.nextInt(100) < 25)
                arr.add(rand.nextInt(upperbound) + (i* upperbound)) ;
            else {
                if (i > 0)
                arr.add(arr.get(i - 1));
                else {
                    arr.add(0) ;
                }
            }
        }
        ArrayProblems.printArr(arr) ;
        ArrayProblems.removeDuplicates(arr);
        ArrayProblems.printArr(arr);

    }

    public static int [] generateRandomSortedArr(int total ) {
        int[] arr = new int[total] ;
        Random rand = new Random() ;

        for (int i = 0 ; i < total ; i++) {
            arr[i] = (rand.nextInt(10)  + i*10 );
        }
        return arr ;
    }

    public static int [] generateRandomArr(int total ) {
        int[] arr = new int[total] ;
        Random rand = new Random() ;

        for (int i = 0 ; i < total ; i++) {
                arr[i] = (rand.nextInt(100) );
        }
        return arr ;
    }

    public static void testRemoveDuplicateaArr () {
        int total = 2 ;
        int[] arr = new int[total] ;
        Random rand = new Random() ;
        int prov = 0 ;
        int upperbound =5 ;
        for (int i = 0 ; i < total ; i++) {
            if (rand.nextInt(100) < 25)
                arr[i] = (rand.nextInt(upperbound) + (i* upperbound) );
            else {
                if (i > 0)
                    arr[i] = arr[i - 1];
                else {
                    arr[i] = 0 ;
                }
            }
        }
        ArrayProblems.printpureAr(arr); ;
        int j = ArrayProblems.removeDuplicatesArr(arr);
        //ArrayProblems.printpureAr(arr);

    }
    public static void testRotateArr() {
        int total = 10 ;
        int[] arr = new int[total] ;

        for (int i = 0 ; i <  total ; i++) {
           arr[i] = i ;
        }
        ArrayProblems.printpureAr(arr);
        ArrayProblems.rotateArr(arr, 2);
    }
    
    public static void testReverse () {
        int upperbound = 100 ;
        LinkedList ll = new LinkedList() ;
        Random rand = new Random() ;
        int count = rand.nextInt(10) + 1 ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            ll.insertNode(val) ;
        }
        ll.printll(ll.getHead());
        ll.printll(ll.reverseLL());

        LinkedList l2 = new LinkedList() ;
        count = rand.nextInt(10) + 1 ; ;
        for (int i = 0 ; i <  count ; i++) {
            int val = rand.nextInt(upperbound)  + (i * upperbound) ;
            l2.insertNode(val) ;
        }
        l2.printll(l2.getHead());
        l2.printll(l2.reverseLL());

    }

    public static void testQuickSort () {
        int [] arr = generateRandomArr(100) ;
        ArrayProblems.printpureAr(arr);
        ArrayProblems.iterativeQsort(arr);
        ArrayProblems.printpureAr(arr);

    }

    public static void testSingleNumber() {
        int count = 20 ;
        int [] arr = generateRandomArr(count) ;
        int [] arrnew = new int[2*count - 1] ;
        for (int i = 0 ; i < (count-1) ; i++) {
            arrnew[i] = arr[i] ;
            arrnew[i+(count-1)] = arr[i] ;
        }
        arrnew[2 * (count-1)] = arr[count-1] ;
        ArrayProblems.printpureAr(arr);
        ArrayProblems.printpureAr(arrnew);
        System.out.println (ArrayProblems.singleNumber(arrnew)) ;
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


    public static void testFibonacci () {
        Fibonacci fib = new Fibonacci() ;
        fib.setFibNum(20);
        System.out.println(fib.calcFib() + " , " + fib.calcFibMem() + " , " + fib.calcFibByFormula());
    }

    public static void testMergeSort () {
        MergeSort mergeSort = new MergeSort() ;
        mergeSort.printArr();
        mergeSort.mergeSort(mergeSort.getArr(), mergeSort.getArr().length);
        mergeSort.printArr();
    }

    public static void main(String[] args) {
       //testBinaryTree () ;
      //  testFibonacci();
      //  testMergeSort();
        EasyProblems.testJudge();
       /*String str = "supercalifraglistic" ;
      /* System.out.println(str);
        System.out.println (StringProblems.reverseString(str))  ;
        System.out.println(StringProblems.isAnagram1("anagram", "nagaram"));
        System.out.println(StringProblems.firstUniqueChar("loveleetcode")) ;
        System.out.println(StringHardProblems.longestSubUniqueChars("geeksforgeeks"));
        System.out.println(StringHardProblems.longestBestUniwueChar("geeksforgeeks"));*/

    }
}
