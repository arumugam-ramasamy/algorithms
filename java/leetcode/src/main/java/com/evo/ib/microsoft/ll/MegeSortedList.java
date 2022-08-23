package com.evo.ib.microsoft.ll;

import com.evo.ib.linkedlist.LinkedCompare;
import com.evo.ib.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*

 */
public class MegeSortedList {
    /*
    You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2 ;
        if (list2 == null) return list1 ;
        ListNode head = new ListNode() ;
        ListNode cur = head ;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1 ;
                list1 = list1.next ;
            }
            else {
                cur.next = list2 ;
                list2 = list2.next ;
            }
            cur = cur.next ;
        }
        if (list1 == null) cur.next = list2 ;
        if (list2 == null) cur.next = list1 ;
        return head.next ;
    }
    /*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
     */
    public static  ListNode mergeKLists(ListNode[] lists) {
        Comparator<LinkedCompare> dataSorter = Comparator.comparing(LinkedCompare::getData);
        Queue<LinkedCompare> priorityQueue = new PriorityQueue<>(dataSorter);
        for (int i = 0 ; i < lists.length ; i++) {
            priorityQueue.add(new LinkedCompare(lists[i].getVal(), i)) ;
        }
        ListNode headMerged = null ;
        ListNode curMerged = headMerged ;
        LinkedCompare curQueue = priorityQueue.poll() ;

        while (curQueue != null) {
            ListNode curNode = lists[curQueue.getInd()] ;
            if (headMerged == null) {
                headMerged = curNode ;
                curMerged = headMerged ;
            }
            else {
                curMerged.next = curNode;
                curMerged = curMerged.next ;
            }
            curNode = curNode.next;
            lists[curQueue.getInd()] = curNode ;
            if (curNode != null)
                priorityQueue.add(new LinkedCompare(curNode.val, curQueue.getInd())) ;
            curQueue = priorityQueue.poll() ;
        }
        curMerged.next = null;
        return headMerged ;

    }
}
