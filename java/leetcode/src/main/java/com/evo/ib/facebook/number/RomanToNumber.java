package com.evo.ib.facebook.number;

public class RomanToNumber {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0 ;
        int num = 0 ;
        int i = 0 ;
        int curvalue = 0 ;
        int curnextvalue = 0 ;
        while (i < s.length() ) {
            curvalue = value(s.charAt(i)) ;
            if (i+1 < s.length()) {
                curnextvalue = value(s.charAt(i+1)) ;
                if (curvalue >= curnextvalue) {
                    num += curvalue  ;
                    i++ ;
                }
                else if (curvalue < curnextvalue) {
                    num += (curnextvalue - curvalue) ;
                    i+= 2 ;
                }
            }
            else {
                num += curvalue ;
                i++ ;
            }
        }
        return num ;
    }

    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
}
