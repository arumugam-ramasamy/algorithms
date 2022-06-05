package com.evo.ib.math;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    Map<Integer, Integer> fib ;
    int fibNum ;

    public Map<Integer, Integer> getFib() {
        return fib;
    }

    public void setFib(Map<Integer, Integer> fib) {
        this.fib = fib;
    }

    public int getFibNum() {
        return fibNum;
    }

    public void setFibNum(int fibNum) {
        this.fibNum = fibNum;
    }

    public Fibonacci() {
        this.fibNum = 0 ;
        fib = new HashMap<>() ;
    }

    public int calcFib () {
        if (fibNum < 1) return 0 ;
        if (fibNum == 1 || fibNum == 2) return 1 ;
        int fibPrev = 1 ;
        int fibPrevPrev = 1 ;
        int fib = 0 ;
        for (int i = 3 ; i <= fibNum ; i++) {
            fib = fibPrev + fibPrevPrev ;
            fibPrevPrev = fibPrev ;
            fibPrev = fib ;
        }
        return fib ;
    }

    public int calcFibMem () {
        if (fibNum < 1) {
            return 0 ;
        }
        if ( fibNum <=2 || fibNum > 2) {
            fib.put(1, 1) ;
            if (fibNum == 1) return fib.get(1) ;
            fib.put(2, 1) ; if (fibNum == 2) return fib.get(2)  ;
        }

        for (int i = 3 ; i <= fibNum ; i++) {
            fib.put(i, fib.get(i-1) + fib.get(i-2)) ;
        }
        return fib.get(fibNum) ;
    }

    public void multiply (int [][] F, int [][] M) {

        int a = F[0][0] * M[0][0] + F[0][1] * M[1][0] ;
        int b  = F[0][0] * M[0][1] + F[0][1] * M[1][1] ;
        int c  = F[1][0] * M[0][0] + F[1][1] * M[1][0] ;
        int d  = F[1][0] * M[0][1] + F[1][1] * M[1][1] ;
        F[0][0] = a ;
        F[0][1] = b ;
        F[1][0] = c ;
        F[1][1] = d ;
    }

    public int calcFibByFormula () {
        double sqrt5 = Math.sqrt(5.0) ;
        double phi = (1+sqrt5)/2.0 ;
        return ((int)  Math.round(Math.pow(phi, fibNum) / sqrt5)) ;
    }
}
