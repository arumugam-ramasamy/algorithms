package com.smic.practice.matrix;

import java.util.HashMap;
import java.util.Map;

public class TestMatrix {

    public static void testCountPaths () {
        int [][] mat = {
                {4,7,1,6},
                {5,7,3,9},
                {3,2,1,2},
                {7,1,6,3}
        } ;
        int cost = 25 ;
        System.out.println ("Total Costs of paths " + cost + " are " +
                Matrix.countPaths(mat, mat.length-1, mat[0].length-1, cost) ) ;
    }

    public static void testCountFastPaths () {
        int [][] mat = {
                {4,7,1,6},
                {5,7,3,9},
                {3,2,1,2},
                {7,1,6,3}
        } ;
        int cost = 25 ;
        Map<String, Integer> lookup = new HashMap<>();
        System.out.println ("Total Costs of paths " + cost + " are " +
                Matrix.countFastPaths(mat, mat.length-1, mat[0].length-1, cost, lookup) ) ;
    }
}
