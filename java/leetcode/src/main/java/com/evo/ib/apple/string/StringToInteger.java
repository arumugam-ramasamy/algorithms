package com.evo.ib.apple.string;

public class StringToInteger {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0 ;
        boolean negative = false ;
        boolean sign = false ;
        s = s.trim() ;
        int len = s.length() ;
        int i = 0 ;
        long  pow = 1 ;
        long num = 0 ;
        if (s.length() == 0) return 0 ;
        if (s.charAt(i) == '-') {
            negative = true ;
            sign = true ;
            i++;
        }
        else {
            if (s.charAt(i) == '+') {
                i++;
                sign = true;
            }
        }
        // the following needs some more refinement
        s = s.replace(",", "") ;
        while ( i < len && !sign && (s.charAt(i) == ' ' || s.charAt(i) == 0)) i++ ;

        while (i < len) {

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * pow + (long) s.charAt(i) - 48L ;
                pow = 10L ;
            }
            else {
                if (num == 0) return 0 ;
                break ;
            }
            if (num > (long) Integer.MAX_VALUE) {
                if (negative)
                    num = Integer.MIN_VALUE ;
                else
                    num = Integer.MAX_VALUE;
                break;
            }
            i++ ;
        }
        if (negative)  {
            if (num >= 0) num = -1 * num ;
        }

        return (int)  num ;
    }

    public static void main(String[] args) {
        System.out.println (myAtoi("9223372036854775808")) ;
    }

}
