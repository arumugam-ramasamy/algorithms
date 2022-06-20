package com.evo.ib.math;

public class GCD {

    public static int GCD(int n1, int n2) {
        if (n2 == 0)
            return n1 ;
        return (GCD(n2, n1%n2)) ;
    }

    public static void main(String[] args) {
        System.out.println (GCD(24, 9));
    }
}
