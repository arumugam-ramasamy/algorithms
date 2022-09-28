package com.evo.ib.google.ArrAndStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0 ;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0] ;
            }
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1] - t1[1] ;
            }
        }) ;
        pq.add(intervals[0]) ;
        for (int i = 1 ; i < intervals.length ; i++) {
            int [] prev = pq.poll() ;
            int [] cur = intervals[i] ;
            if (cur[0] < prev[1]) {
                pq.add(cur) ;
                pq.add(prev) ;
            }
            else {
                prev[1] = Math.max(cur[1], prev[1]) ;
                pq.add(prev) ;
            }
        }
        return pq.size() ;
    }
}
