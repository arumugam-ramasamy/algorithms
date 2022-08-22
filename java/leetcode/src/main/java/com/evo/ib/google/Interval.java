package com.evo.ib.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Interval
{
    int start,end;

    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public static int mergeIntervals (Interval [] arr) {
        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start - i2.start;
            }
        });
        int index = 0 ;

        for (int i = 1 ; i < arr.length ;i++){
            if (arr[i].getStart() <= arr[index].getEnd()) {
                arr[index].setEnd(Math.max(arr[index].end, arr[i].end));
            }
            else {
                index++ ;
                arr[index] = arr[i] ;
            }
        }
        return  index ;
    }

    public static void main(String[] args) {
        Interval arr[]=new Interval[7];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        arr[4] = new Interval(10, 20) ;
        arr[5] = new Interval(9, 12) ;
        arr[6] = new Interval(20, 40) ;
        for (int i = 0 ; i < arr.length; i++) {
            Interval inSE = (Interval) arr[i] ;
            System.out.println(inSE.getStart() + " " + inSE.getEnd());
        }
        int ind = Interval.mergeIntervals(arr);
        System.out.println("---------------------------------");
        for (int i = 0 ; i <= ind; i++) {
            Interval inSE = (Interval) arr[i] ;
            System.out.println(inSE.getStart() + " " + inSE.getEnd());
        }
    }
}