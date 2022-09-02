package com.evo.ib.top.array;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null ;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                    return ints[0] - t1[0] ;
            }
        });

        int index = 0 ;
        for (int i = 1 ; i < intervals.length ; i++) {
            if (intervals[i][0] <= intervals[index][1] ) {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]) ;
            }
            else {
                index++ ;
                intervals[index] = intervals[i] ;
            }
        }
        int[][] newinterval = new int[index+1][2] ;
        for (int i = 0 ; i <= index ; i++) {
            newinterval[i] = intervals[i] ;
        }
        return newinterval ;
    }
}
