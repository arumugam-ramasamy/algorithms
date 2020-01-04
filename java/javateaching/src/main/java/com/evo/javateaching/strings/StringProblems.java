package com.evo.javateaching.strings;

import java.util.Arrays;

public class StringProblems {

    public static String reverseString(String str) {

        if (str == null) return null;
        if (str.length() <= 1) return str;

        char[] strChrs = str.toCharArray();
        int end = strChrs.length - 1;
        for (int i = 0; i < strChrs.length / 2; i++) {
            char ch = strChrs[i];
            strChrs[i] = strChrs[end - i];
            strChrs[end - i] = ch;
        }

        return new String(strChrs);
    }

    public static void strBuilder(String str) {
        long t;
        t = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int j = 0 ; j < 10000000 ; j++) {
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println("Time it took using stringbuilder to build is " + (System.currentTimeMillis() - t));

    }

    public static void strBuffer(String str) {
        long t;
        t = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < 10000000 ; j++) {
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println("Time it took using stringbuffer to build  is " + (System.currentTimeMillis() - t));
    }

    public static boolean isPalindrome (String str) {
        if (str == null) return true ;
        if (str.length() <= 1) return true ;
        if (str.equals(reverseString(str))) return true ;
        return false ;
    }

    public static boolean isPalindrome2(String str) {
        if (str == null) return true ;
        if (str.length() <= 1) return  true ;
        int end = str.length() -1 ;
        int i = 0 ; ;
        while (i  < str.length()/2) {
            if (str.charAt(i) != str.charAt(end -i ))
                return  false ;
            i++ ;
        }
        return true ;
    }

    public static  void testPalindrome() {
        System.out.println(isPalindrome("hello there"));
        System.out.println(isPalindrome("church") ) ;
    }

    public static boolean isAnagram(String str1, String str2) {
        int [] count = new int[256] ;
        Arrays.fill(count, 0);

        if (str1.length() != str2.length()) return false ;

        for (int i = 0 ; i < str1.length() ; i++){
            count[str1.charAt(i)]++ ;
            count[str2.charAt(i)]-- ;
        }

        for (int i = 0 ; i < 256 ; i++) {
            if (count[i] != 0 ) return false ;
        }
        return true ;
    }

    public static void builderVersusBuffer(String str) {
        strBuffer(str);
        strBuilder(str);
    }

    public static void testReverseString() {
        System.out.println("reverse(StringProblems)  is = " + reverseString("StringProblems"));
        System.out.println("reverser() is = " + reverseString(null));
        System.out.println("reverse(a) is = " + reverseString("a"));
        builderVersusBuffer("StringProblemssupercalifragilisticexpialidotius");
    }

    public static void main(String[] args) {
        testReverseString();
    }
}
