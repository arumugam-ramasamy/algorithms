package com.evo.ib.arrays;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {

        int carry = 1 ;
        int i = digits.length-1 ;
        while (i>= 0) {
            int res = digits[i]  + carry ;
            if (res == 10) {
                digits[i] = 0;
                carry = 1;
            }
            else {
                digits[i] = res ;
                carry = 0 ;
            }
            i-- ;
            if (carry == 0) break ;
        }
        if (carry == 0) return digits ;
        int [] newdigits = new int[digits.length+1] ;
        newdigits[0] = 1 ;
        for (int j = 0 ; j < digits.length ; j++) {
            newdigits[j + 1] = digits[j];
        }
        return newdigits ;

    }

    public static void main(String[] args) {
        int [] arr = {9, 9, 9, 9, 9, 9, 9, 9} ;
        System.out.println(Arrays.toString(plusOne(arr))) ;
    }
}
