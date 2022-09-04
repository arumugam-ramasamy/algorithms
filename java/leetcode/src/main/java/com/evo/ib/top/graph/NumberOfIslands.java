package com.evo.ib.top.graph;

import java.util.Arrays;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null && grid.length == 0) return 0 ;
        int count = 0 ;
        int rows = grid.length ;
        int cols = grid[0].length ;
        boolean[][] visited = new boolean[rows][cols] ;
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < cols ; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    DFS(grid, i, j, visited);
                    count++ ;
                }
            }
        }
        return count ;
    }

    public void DFS (char [][] grid, int row, int col, boolean[][] visited) {

        //int[] NeighRow = {-1, -1, -1, 0, 0, 1, 1,1} ;
        //int[] NeighCol = {-1, 0, 1, -1, 1, -1, 0, 1} ;
       int[] NeighRow = {-1, 0, 0, 1} ;
       int[] NeighCol = { 0,-1, 1, 0} ;


        visited[row] [col] = true ;

        for (int l = 0 ; l < NeighRow.length; l++) {

                if (isSafe(grid, row+NeighRow[l], col+NeighCol[l], visited))
                    DFS(grid, row+NeighRow[l], col+NeighCol[l], visited) ;

        }
    }

    public boolean isSafe(char [][] grid, int row, int col, boolean [][] visited) {
        return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1' && !visited[row][col]) ;
    }

    public static void main(String[] args) {
        char M[][] = new char[][] { { '1', '1', '0', '0', '0' },
                                    { '1', '1', '0', '0', '0' },
                                    { '0', '0', '1', '0', '0'},
                                    { '0', '0', '0', '1', '1' } };
        NumberOfIslands I = new NumberOfIslands();
        System.out.println("Number of islands is: " + I.numIslands(M));
    }
}
