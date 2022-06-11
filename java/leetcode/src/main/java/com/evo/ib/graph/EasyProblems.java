package com.evo.ib.graph;

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
}
