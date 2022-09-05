package com.evo.ib.google.ArrAndStrings;

public class MaxDistanceToClosest {
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) return 0;
        double currentMax = 0;
        int prevFilled = -1;
        int i = 0;
        while (i < seats.length) {
            if (seats[i] == 0) {
                i++;
                continue;
            } else {
                if (prevFilled == -1) {
                    currentMax = i;
                    prevFilled = i;
                } else {
                    double newmax = i - prevFilled;
                    prevFilled = i ;
                    newmax =  Math.floor((double) newmax/ 2.0) ;
                    if (newmax > currentMax) currentMax = newmax ;
                }
                i++;
            }
        }
        if (prevFilled == -1) return (i-1) ;
        int lastmax = i - 1 - prevFilled ;
        if (lastmax > currentMax) currentMax = lastmax;
        return (int) currentMax ;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,0,0,1,1,0,0,1,0};
        MaxDistanceToClosest maxDistanceToClosest = new MaxDistanceToClosest() ;
        System.out.println (maxDistanceToClosest.maxDistToClosest(arr)) ;
    }

}
