package com.evo.ib.top.number;

import java.util.HashMap;
import java.util.Map;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return check(n) ;
    }

    public boolean logMethod (int n) {

        double dividend = Math.log((double)n) ;
        double divisor = Math.log(3.0) ;
        double ans = dividend/divisor ;

        if (ans ==  (double) ((int) ans) ) return true ;
        return false ;
    }

    public boolean isPowerThree (int n) {

        if (n == 1)
            return true;
        int lastDigit = n % 10;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 1);
        map.put(9, 2);
        map.put(7, 3);
        map.put(1, 4);

        if (map.get(lastDigit) == null)
            return false;

        int power = map.get(lastDigit);
        double powerOfThree = Math.pow(3, power);
        while (powerOfThree <= n) {
            if (powerOfThree == n)
                return true;
            power = power + 4;
            powerOfThree = Math.pow(3, power);
        }
        return false;
    }

    public boolean check(int n)
    {
        /* To prevent
        java.lang.ArithmeticException: / by zero and
        negative n */
        if (n <= 0)
            return false;
        /* The maximum power of 3 value that
           integer can hold is 1162261467 ( 3^19 ) .*/
        return 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree() ;
        //System.out.println("9 is it " + powerOfThree.isPowerOfThree(9) ) ;
        //System.out.println("18 is it " + powerOfThree.isPowerOfThree(18) ) ;
        //System.out.println("27 is it " + powerOfThree.isPowerOfThree(27) ) ;
        System.out.println("243 is it " + powerOfThree.isPowerOfThree(243) ) ;
    }
}
