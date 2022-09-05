package com.evo.ib.google.ArrAndStrings;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class KClosestOrigin {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) return null ;
        PriorityQueue<Point> pqueue = new PriorityQueue<>() ;
        for (int i = 0 ; i < points.length ; i++)   {
            Point point = new Point(points[i][0], points[i][1]) ;
            pqueue.offer(point) ;
            if (pqueue.size() > k) pqueue.poll() ;
        }
        int[][] ans = new int[pqueue.size()][2] ;
        int i = 0 ;
        while (pqueue.size() > 0) {
            Point point = pqueue.poll() ;
            ans[i][0] = point.x ;
            ans[i][1] = point.y ;
            i++ ;
        }
        return ans ;
    }

    public class Point implements Comparable<Point> {
        int x ;
        int y ;
        double distance ;

        public Point (int x, int y) {
            this.x = x ;
            this.y = y ;
            distance = (double) ((x *x) + (y * y)) ;
            distance = Math.sqrt(distance) ;
        }

        @Override
        public int compareTo(@NotNull Point point) {
            if (this.distance < point.distance)
                return 1 ;
            if (this.distance == point.distance)
                return 0 ;
            return -1 ;
        }
    }
}
