package com.evo.ib.number;

public class Divide {
    public static int divide(int dividend, int divisor) {
        boolean sign = false;
        long dividendlong = (long) dividend;
        long divisorlong = (long) divisor;
        if (dividend == Integer.MAX_VALUE && Math.abs(divisor) == 1) {
            if (divisor < 0) return (Integer.MAX_VALUE * -1);
            else return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1) {
            if (divisor < 0) return (Integer.MAX_VALUE);
            else return Integer.MIN_VALUE;
        }
        if (dividend < 0 && divisor >= 0) {
            dividendlong *= -1;
            sign = true;
        }
        if (dividend >= 0 && divisor < 0) {
            divisorlong *= -1;
            sign = true;
        }
        if (dividend < 0 && divisor < 0) {
            dividendlong *= -1;
            divisorlong *= -1;
        }
        if (dividendlong < divisorlong) return 0;
        if (divisorlong == 0) return 0;
        if (divisorlong == 1) {
            if (sign)
                return ((int) (-1L * dividendlong));
            else
                return ((int) dividendlong);
        }

        long ans = 0;

        while (dividendlong >= divisorlong) {
            dividendlong -= divisorlong;
            if (ans < Integer.MAX_VALUE)
                ++ans;
            else break;
        }
        if (sign) ans *= -1L;
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }
}
