package com.evo.ib.top.matrix;

public class LongestIncrPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) return -1 ;
        int m = matrix.length ;
        int n = matrix[0].length ;
        int [][] memory = new int[m][n] ;
        int result = 0 ;
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++){
                int t = findmax(matrix, i, j, memory) ;
                result = Math.max(result, t) ;
            }
        }
        return result ;
    }

    public int findmax(int[][] matrix, int i, int j, int[][] mem) {
        if (mem[i][j] > 0)
            return mem[i][j] ;

        int[] dx = {-1, 0, 1, 0} ;
        int[] dy = {0, -1, 0, 1} ;
        int m = matrix.length ;
        int n = matrix[0].length ;

        for (int k = 0 ; k < dx.length ; k++) {
            int x = i + dx[k] ;
            int y = j + dy[k] ;
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                mem[i][j] = Math.max(mem[i][j], findmax(matrix, x, y, mem)) ;
            }
        }
        return ++mem[i][j] ;
    }
}
