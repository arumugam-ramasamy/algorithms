package com.evo.ib.strings;

public class ReverseInteger {
    public static int reverse(int x) {
        if (Math.abs((long) x) <= 9) return x ;
        boolean sign = false ;
        if (x < 0) {
            sign = true ;
            x = -1 * x ;
        }

        long ans = 0 ;
        int pow = 1 ;

        while (x > 0) {
            ans = ans * pow + (x %10) ;
            if (ans != 0)
                pow = 10 ;
            x = x / 10 ;
        }
        if (sign) ans = ans * -1L ;
        if (ans < (long) Integer.MIN_VALUE || ans > (long) Integer.MAX_VALUE) return 0 ;
        return (int) ans ;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
