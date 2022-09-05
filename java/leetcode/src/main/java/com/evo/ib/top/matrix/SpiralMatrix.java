package com.evo.ib.top.matrix;

import sun.security.provider.ConfigFile;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null ;
        int m = matrix.length ;
        int n =  matrix[0].length ;
        int x = 0 , y = 0 ;
        List<Integer> res = new ArrayList<>() ;
        while (m > 0 && n > 0) {

            if (m == 1) {
                for (int i = 0 ; i < n ; i++) {
                    res.add(matrix[x][y++]) ;
                }
                break ;
            }
            if (n == 1) {
                for (int i =0  ; i < m ; i++ ) {
                    res.add(matrix[x++][y]) ;
                }
                break ;
            }
            // right
            for (int i = 0 ; i <n-1 ; i++) {
                res.add(matrix[x][y++]) ;
            }
            // down
            for (int i = 0 ; i < m-1 ; i++) {
                res.add(matrix[x++][y]) ;
            }

            // left
            for (int i = 0 ; i <n-1 ; i++) {
                res.add(matrix[x][y--]) ;
            }
            //up
            for (int i = 0 ; i < m-1 ; i++) {
                res.add(matrix[x--][y]) ;
            }
            x++ ;
            y++ ;
            m = m -2 ;
            n=n-2 ;
        }
        return res ;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}} ;
        SpiralMatrix spiralMatrix = new SpiralMatrix() ;
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

}
