package com.evo.ib.facebook.strings;

public class AddTwoBinary {
    public String addBinary(String a, String b) {
        if (b == null || b.length() == 0) return a ;
        if (a == null || a.length() == 0)  return b ;
        int carry = 0 ;
        for (int i = 0 , j = 0 ; (i < a.length() && j < b.length()) ; i++,j++) {
            if (a.charAt(i) == '1' || b.charAt(i) == '1') {

            }
        }
        return a ;
    }
}
