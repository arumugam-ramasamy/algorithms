package com.evo.ib.top.number;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsLine {
    static int gcd(int p, int q)
    {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0 ;
        if (points.length < 2) return points.length ;
        Map<String, Integer> slopeCounts = new HashMap<>() ;
        int maxPoint = 0;
        int curMax, overlapPoints, verticalPoints;
        for (int i = 0 ; i < points.length - 1 ; i++) {
            curMax = overlapPoints = verticalPoints = 0 ;
            for (int j = i+1 ; j < points.length ; j++) {
                if (points[i][0] == points[j][0]  &&
                    points[i][1] == points[j][1])
                    ++overlapPoints ;
                else if (points[i][0] == points[j][0])
                    ++verticalPoints ;
                else {
                    int xdiff = points[i][0] - points[j][0] ;
                    int ydiff = points[i][1] - points[j][1] ;
                    int gcd = gcd (xdiff, ydiff) ;
                    xdiff = xdiff/gcd ;
                    ydiff = ydiff/gcd ;
                    String key = xdiff + "_" + ydiff ;
                    if (!slopeCounts.containsKey(key)) {
                        slopeCounts.put(key, 0) ;
                    }
                    slopeCounts.put(key, slopeCounts.get(key) + 1) ;
                    curMax = Math.max(curMax, slopeCounts.get(key)) ;
                }
                curMax = Math.max(curMax, verticalPoints) ;
            }
            maxPoint = Math.max(maxPoint, curMax+overlapPoints+1) ;
            slopeCounts.clear();
        }
        return maxPoint ;
    }
}
