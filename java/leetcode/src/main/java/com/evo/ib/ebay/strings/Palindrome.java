package com.evo.ib.ebay.strings;

public class Palindrome {

    public static boolean isPalindrome (String str) {
        if (str == null || str.length() <= 1) return true ;
        str = str.toLowerCase() ;

        int i = 0 ;
        int j = str.length()-1 ;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false ;
            ++i ;
            --j ;
        }
        return true ;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abBA"));
    }
}
