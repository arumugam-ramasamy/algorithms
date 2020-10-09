package com.smic.practice.matrix;

import java.util.Map;

public class Matrix {

    public static int countFastPaths(int [][] matrix, int m, int n, int cost, Map<String, Integer> lookup){

        if (cost< 0) return 0 ;
        if (m == 0 && n == 0) {
            if ((cost - matrix[m][n]) == 0)
                return 1 ;
            else
                return 0 ;
        }

        String key = m + "|" + n + "|" + cost ;

        if (!lookup.containsKey(key)) {
            if (m == 0) {
                lookup.put(key, countFastPaths(matrix, 0, n - 1, cost - matrix[m][n], lookup));
            } else if (n == 0) {
                lookup.put(key, countFastPaths(matrix, m - 1, 0, cost - matrix[m][n], lookup));
            } else {
                lookup.put(key, countFastPaths(matrix, m, n - 1, cost - matrix[m][n], lookup) +
                        countFastPaths(matrix, m - 1, n, cost - matrix[m][n], lookup));
            }
        }
        return lookup.get(key);
    }

    public static int countPaths(int [][] matrix, int m, int n, int cost){

        if (cost < 0)
            return 0 ;

        if (m == 0 && n == 0) {
            if (cost - matrix[m][n] == 0)
                return 1 ;
            else
                return 0 ;
        }

        if (m == 0) {
            return countPaths(matrix, 0, n-1, cost - matrix[m][n]) ;
        }
        if (n == 0){
            return countPaths(matrix, m-1, 0, cost - matrix[m][n]) ;
        }

        return (countPaths(matrix, m, n-1, cost - matrix[m][n])  +
                countPaths(matrix, m-1, n, cost - matrix[m][n]) ) ;
    }
}
