package com.evo.ib.disney.number;

public class ReverseInteger {
    public static Integer reverseDigits (int val)  {
        if (Math.abs(val) < 10) return val ;
        Boolean sign = false ;
        if (val < 0) {
            sign = true ;
            val = val * -1 ;
        }
        int temp = 0 ;
        int power10 = 1 ;
        while (val > 0) {
            temp = (temp * power10) + (val % 10) ;
            val = val / 10 ;
            power10 = 10 ;
        }

        if (sign)  return -1 * temp ;
        return temp ;
    }

    public static void main(String[] args) {
        System.out.println("56789 rev is " + reverseDigits(-56789));
    }
}
