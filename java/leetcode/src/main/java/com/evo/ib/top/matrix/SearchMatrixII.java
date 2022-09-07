package com.evo.ib.top.matrix;

public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false ;
        int rows = matrix.length ;
        int cols = matrix[0].length ;
        int r = 0 ;
        int c = cols-1 ;
        while (r < rows && c >= 0) {
            if (target > matrix[r][c])
                ++r ;
            else if (target < matrix[r][c])
                --c ;
            else return true ;
        }
        return false ;

    }
}
