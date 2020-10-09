package com.smic.practice.strings;

/**
 * Created by PranavsMac on 9/27/20.
 */
public class Palindrome {

    public static boolean isPalindrome (String str) {


        if (str == null || str.length() <= 1) return true ;

        StringBuilder sb = new StringBuilder() ;

        for (int i = 0 ; i < str.length() ; i++) {
            if (Character.isAlphabetic(str.charAt(i)))
                sb.append(str.charAt(i)) ;
        }

        str = sb.toString().toLowerCase();

        for (int i = 0 ; i < str.length()/2 ; i++) {
            if (str.charAt(str.length()-1-i)  !=
                    str.charAt(i)) {
                return false ;
            }
        }
        return true ;
    }

   static boolean isThisSentenceAPalindromeOrderN1(String s) {
        if (s==null) return false;
        if (s.length()<=1) return true;
        s = s.toLowerCase();
        int i = 0 ;
        int j = s.length() -1 ;
        int len = s.length() ;
        while (i < len && !Character.isAlphabetic(s.charAt(i))) ++i;
        while (j >= 0 && !Character.isAlphabetic(s.charAt(j))) --j ;
        while (j >= i) {

            if (s.charAt(i)!=s.charAt(j)) return false;
            ++i ; --j ;
            while (i < len && !Character.isAlphabetic(s.charAt(i))) ++i;
            while (j >= 0 && !Character.isAlphabetic(s.charAt(j))) --j ;

        }

        return true;
    }

    static boolean isThisSentenceAPalindromeOrderN(String s) {
        if (s==null) return false;
        if (s.length()<=1) return true;
        s = s.toLowerCase();
        for (int i=0, j=s.length()-1; i<s.length()/2; ++i, --j) {
            while (i < s.length() &&  !Character.isAlphabetic(s.charAt(i))) ++i;
            while (j >= 0 && !Character.isAlphabetic(s.charAt(j))) --j;
            if (j < i) break ;
            if (s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
       // "dammit i'm mad"

       System.out.println ("abccba = " + Palindrome.isThisSentenceAPalindromeOrderN("abccba")) ;
        System.out.println ("accba = " + Palindrome.isThisSentenceAPalindromeOrderN("accba")) ;
        System.out.println ("a = " + Palindrome.isPalindrome("a")) ;
        System.out.println ("church = " + Palindrome.isPalindrome("church")) ;
        System.out.println("dammit i'm mad = " + Palindrome.isThisSentenceAPalindromeOrderN1("dammit i'm mad"));

    }

}
