package com.evo.ib.arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        if (matrix.length != matrix[0].length) return ;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    public static void printMatrix (int [][] mat) {
        for (int i = 0 ; i < mat[0].length ; i++) {
            for (int j = 0 ; j < mat[0].length ; j++) {
                System.out.print(mat[i][j] + " ") ;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}} ;
        printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        printMatrix(matrix);

    }
}
