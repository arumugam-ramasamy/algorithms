package com.evo.ib.top.matrix;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int zeroInd = -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (matrix[i][j] < low) low = matrix[i][j];
                if (matrix[i][j] > high) high = matrix[i][j];
            }
        }
        zeroInd = low -1 ;
        if (low == Integer.MIN_VALUE)
            zeroInd = low + 1;
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    int k = i - 1;
                    while (k >= 0) {
                        if (matrix[k][j] != 0)
                            matrix[k--][j] = zeroInd;
                        else --k;
                    }
                    k = i + 1;
                    while (k < rows) {
                        if (matrix[k][j] != 0)
                            matrix[k++][j] = zeroInd;
                        else ++k;
                    }
                    k = j - 1;
                    while (k >= 0) {
                        if (matrix[i][k] != 0)
                            matrix[i][k--] = zeroInd;
                        else --k;
                    }
                    k = j + 1;
                    while (k < cols) {
                        if (matrix[i][k] != 0)
                            matrix[i][k++] = zeroInd;
                        else ++k;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == zeroInd) matrix[i][j] = 0;
            }
        }

    }

    public void setZeroesExtraSpace(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newmatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newmatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    int k = i;
                    while (k >= 0) newmatrix[k--][j] = 0;
                    k = i;
                    while (k < rows) newmatrix[k++][j] = 0;
                    k = j;
                    while (k >= 0) newmatrix[i][k--] = 0;
                    k = j;
                    while (k < cols) newmatrix[i][k++] = 0;
                }

            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = newmatrix[i][j];
            }
        }
    }

    public void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.printMatrix(mat);
        setZeroes.setZeroes(mat);
        setZeroes.printMatrix(mat);
    }
}
