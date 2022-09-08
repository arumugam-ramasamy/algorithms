package com.evo.ib.top.matrix;

public class UniquePaths {
    int[][] countUniquePaths;
    int numberOfRows;
    int numberOfColumns;

    public int uniquePaths(int m, int n) {
        countUniquePaths = new int [m][n] ;
        numberOfRows = m ;
        numberOfColumns = n ;
        int x = m - 1;
        int y = n - 1 ;
        while (x >= 0 && y >= 0) {
            for (int i = x ; i >= 0 ; i--) {
                calcUniquePaths(i, y);
            }
            for (int j = y-1 ; j >= 0 ; j--) {
                calcUniquePaths(x, j);
            }
            x-- ;
            y-- ;
        }
        return (countUniquePaths[0][0]) ;
    }

    public void calcUniquePaths (int i, int j) {
        if (i == numberOfRows -1) {
            if (j == numberOfColumns -1) {
                countUniquePaths[i][j] = 1;
            }
            else {
                countUniquePaths[i][j] = countUniquePaths[i][j+1] ;
            }
        }
        else if (j == numberOfColumns-1) {
                countUniquePaths[i][j] = countUniquePaths[i+1][j] ;
        }
        else {
                countUniquePaths[i][j] = countUniquePaths[i][j+1] + countUniquePaths[i+1][j] ;
        }
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths() ;
        System.out.println (uniquePaths.uniquePaths(3, 7)) ;
    }
}
