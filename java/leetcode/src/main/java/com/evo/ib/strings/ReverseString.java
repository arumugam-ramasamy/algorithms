package com.evo.ib.strings;

public class ReverseString {
    public static void reverseString(char[] s) {

        if (s == null || s.length <= 1) return ;
        int left = 0 ;
        int right = s.length -1 ;
        while (left < right) {
            char ch = s[left] ;
            s[left] = s[right] ;
            s[right] = ch ;
            ++left ;
            --right ;
        }

    }
}
