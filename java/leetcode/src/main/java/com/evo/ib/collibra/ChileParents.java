package com.evo.ib.collibra;
 /*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.

               15
              / \
         14  13  21
         |   |
1   2    4   12
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11

pairs = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (15, 21), (4, 8), (4, 9), (9, 11), (14, 4), (13, 12),
    (12, 9), (15, 13)
]

Write a function that takes this data and the identifiers of two individuals as inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(pairs, 3, 8)   => false
hasCommonAncestor(pairs, 5, 8)   => true
hasCommonAncestor(pairs, 6, 8)   => true
hasCommonAncestor(pairs, 6, 9)   => true
hasCommonAncestor(pairs, 1, 3)   => false
hasCommonAncestor(pairs, 3, 1)   => false
hasCommonAncestor(pairs, 7, 11)  => true
hasCommonAncestor(pairs, 6, 5)   => true
hasCommonAncestor(pairs, 5, 6)   => true
hasCommonAncestor(pairs, 3, 6)   => true
hasCommonAncestor(pairs, 21, 11) => true

n: number of pairs in the input
*/

import java.util.*;


public class ChileParents {

    public static Map<Integer, List<Integer>> parentLists(int[][] childParents) {
        if (childParents == null || childParents.length == 0) return null;
        Map<Integer, List<Integer>> parentList = new HashMap<>();
        Set<Integer> peopleList = new HashSet<>();
        for (int i = 0; i < childParents.length; i++) {
            if (childParents.length <= 1) continue;
            int child = childParents[i][1];
            int parent = childParents[i][0];
            if (parentList.containsKey(child)) {
                List<Integer> parents = parentList.get(child);
                if (parents.size() >= 2) {
                    System.err.println("error");
                    continue;
                }
                parents.add(parent);
                parentList.put(child, parents);
            } else {
                List<Integer> parents = new ArrayList<>();
                parents.add(parent);
                parentList.put(child, parents);
            }
            peopleList.add(child);
            peopleList.add(parent);
        }
        return parentList;
    }


    public static Map<Integer, Set<Integer>> knowParents(int[][] childParents) {

        if (childParents == null || childParents.length == 0) return null;
        Map<Integer, List<Integer>> parentList = new HashMap<>();
        Set<Integer> peopleList = new HashSet<>();
        for (int i = 0; i < childParents.length; i++) {
            if (childParents.length <= 1) continue;
            int child = childParents[i][1];
            int parent = childParents[i][0];
            if (parentList.containsKey(child)) {
                List<Integer> parents = parentList.get(child);
                if (parents.size() >= 2) {
                    System.err.println("error");
                    continue;
                }
                parents.add(parent);
                parentList.put(child, parents);
            } else {
                List<Integer> parents = new ArrayList<>();
                parents.add(parent);
                parentList.put(child, parents);
            }
            peopleList.add(child);
            peopleList.add(parent);
        }

        Map<Integer, Set<Integer>> kps = new HashMap<>();
        Set<Integer> iv = new HashSet<>();
        kps.put(0, iv);
        iv = new HashSet<>();
        kps.put(1, iv);
        for (Integer person : peopleList) {
            if (parentList.containsKey(person)) {

                if (parentList.get(person).size() == 1) {
                    Set<Integer> listPersons = kps.get(1);
                    listPersons.add(person);
                    kps.put(1, listPersons);
                }
            } else {
                Set<Integer> listPersons = kps.get(0);
                listPersons.add(person);
                kps.put(0, listPersons);
            }

        }

        return kps;
    }


}

