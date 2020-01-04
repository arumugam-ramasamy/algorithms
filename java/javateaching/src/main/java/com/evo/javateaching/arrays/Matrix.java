package com.evo.javateaching.arrays;

import java.util.Random;

public class Matrix {

    int[][] matrix;
    int row;
    int column;
    Random rand = new Random();

    public Matrix() {

        int row = 3;
        int col = 3;

        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
    }

    public Matrix(int row, int col) {
        if (row < 0) row = 3;
        if (col < 0) col = 3;
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void add(int[][] mat) {

        if (mat.length != this.getRow()) {
            System.err.println("For addition, rows of matrix must be equal");
            System.exit(1);
        }
        if (mat.length >= 1 && mat[0].length != this.getColumn()) {
            System.err.println("For addition, columms of matrix must be equal");
            System.exit(1);
        }

        for (int i = 0 ; i < getRow() ; i++) {
            for (int j = 0 ; j < getColumn() ; j++) {
                matrix[i][j]  += mat[i][j] ;
            }
        }
    }

    public void printMatrix (int[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j] +  "\t") ;
            }
            System.out.println() ;
        }
    }

    public int[][] matrixMultiplication(int[][] mat) {
        if (this.getColumn() != mat.length) {
            System.err.println("The two matrix col and row are not equal and cannot be multiplied");
            return null ;
        }
        int [][] result = new int[this.getRow()][mat[0].length] ;
        for (int i = 0 ; i < result.length ; i++) {
            for (int j = 0 ; j < result[0].length ; j++) {
                result[i][j] = 0 ;
            }
        }
        for(int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < getColumn(); k++) {
                    result[i][j] += this.getMatrix()[i][k] * mat[k][j];
                }
            }
        }
        return result ;
    }
}
