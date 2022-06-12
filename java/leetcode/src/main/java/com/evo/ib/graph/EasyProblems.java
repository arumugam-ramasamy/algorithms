package com.evo.ib.graph;

import java.util.*;

public class EasyProblems {

    public static int findJudge (int N, int [][] trusts) {
        int[] trustCount = new int[N+1] ;

        for (int[] trust : trusts ) {
            trustCount[trust[0]]-- ;
            trustCount[trust[1]]++ ;
        }

        for (int i = 1 ; i <= N ; i++) {
            if (trustCount[i] == N-1) return i ;
        }
        return -1 ;
    }

    public static void createAdjList (int [][] edges, Map<Integer, Set<Integer>> adjlist){

        for (int [] edge : edges) {
            Set<Integer> adj = null ;
            if (adjlist.containsKey(edge[0]) == false) {
                adj = new HashSet<>() ;
            }
            else {
                adj = adjlist.get(edge[0]) ;
            }
            adj.add(edge[1]) ;
            adjlist.put(edge[0], adj) ;

            if (adjlist.containsKey(edge[1]) == false) {
                adj = new HashSet<>() ;
            }
            else {
                adj = adjlist.get(edge[1]) ;
            }
            adj.add(edge[0]) ;
            adjlist.put(edge[1], adj) ;
        }

    }

    public static boolean hasPath (int N, int[][] edges, int source, int destination) {
        if (N <= 1) return false ;
        if (source > N) return false ;
        if (destination > N) return false ;
        if (edges.length == 0) return false ;
        Map<Integer, Set<Integer>> adjlist = new HashMap<>() ;
        createAdjList(edges, adjlist);
        Queue<Integer> queue = new LinkedList<>() ;
        queue.add(source) ;;
        boolean[] seen = new boolean[N] ;

        seen[source] = true ;
        while (queue.size() > 0) {
            int cur = queue.remove() ;
            if (cur == destination) return true ;
            Set<Integer> adjs = adjlist.get(cur) ;
            for (int adj : adjs) {
                if (!seen[adj]) {
                    queue.add(adj) ;
                    seen[adj] = true ;
                }
            }
        }
        if (seen[destination] == true) return true ;
        return false ;
    }

    public static boolean hasPathStack (int N, int[][] edges, int source, int destination) {
        if (N <= 1) return false ;
        if (source > N) return false ;
        if (destination > N) return false ;
        if (edges.length == 0) return false ;
        Map<Integer, Set<Integer>> adjlist = new HashMap<>() ;
        createAdjList(edges, adjlist);
        Stack<Integer>stack = new Stack<>() ;
        stack.push(source) ;;
        boolean[] seen = new boolean[N] ;

        seen[source] = true ;
        while (stack.size() > 0) {
            int cur = stack.pop() ;
            if (cur == destination) return true ;
            Set<Integer> adjs = adjlist.get(cur) ;
            for (int adj : adjs) {
                if (!seen[adj]) {
                    stack.push(adj) ;
                    seen[adj] = true ;
                }
            }
        }
        if (seen[destination] == true) return true ;
        return false ;
    }

    public static int getStarNode(int N, int[][] edges) {
        if (N <= 1) return -1 ;
        if (edges.length == 0) return -1 ;
        Map<Integer, Set<Integer>> adjlist = new HashMap<>() ;
        createAdjList(edges, adjlist);
        for (Map.Entry<Integer, Set<Integer>> entry : adjlist.entrySet()) {
            if (entry.getValue().size() == (N-1)) return entry.getKey() ;
        }
        return -1 ;
    }

    public static void testJudge () {
        int [][] testdata = new int[][]{{1,2}} ;
        System.out.println (findJudge(2, testdata  )) ;
        testdata =  new int[][] {{1,3},{2,3}} ;
        System.out.println (findJudge(3, testdata  )) ;
        testdata =  new int[][] {{1,3},{2,3},{3,1}} ;
        System.out.println (findJudge(3, testdata  )) ;
        testdata =  new int[][] {{1,3},{1, 4},{2,3},{2,4},{4,3}, {1, 5}, {5,3}} ;
        System.out.println (findJudge(5, testdata  )) ;
    }

    public static void testHasPath() {
        int [][]testdata = new int[][] {{0, 1}, {1, 2}, {2, 3} } ;
        System.out.println (hasPath(5, testdata, 0, 4)) ;
        System.out.println (hasPathStack(4, testdata, 0, 3)) ;
    }

    public static void testStar() {
        int [][]testdata = new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3} } ;
        System.out.println (getStarNode(4, testdata)) ;
        testdata = new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3} , {4, 2}} ;
        System.out.println (getStarNode(5, testdata)) ;
    }
}
