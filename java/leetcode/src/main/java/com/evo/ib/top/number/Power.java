package com.evo.ib.top.number;

public class Power {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }
    public double power(double x, int n) {
        if (n == 0)
            return 1;
        double v = power(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
    public double pow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }

    public static void main(String[] args) {

        Power power = new Power() ;
        System.out.println(power.pow(3, 6));
        System.out.println(power.pow(2, -6));
    }
}
