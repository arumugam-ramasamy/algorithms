package com.evo.ib.top.strings;

import java.util.HashSet;
import java.util.Set;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return -1 ;
        if (haystack.length() == 0) return -1 ;
        int [] LPS = new int[needle.length()] ;
        computeLPS(LPS, needle) ;
        int i = 0 ;
        int j = 0 ;
        int needlelength = needle.length() ;
        int haystacklength = haystack.length() ;

        while (i < haystacklength) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++j ;
                ++i ;
            }
            if (j == needlelength) {
                return (i -j) ;
            }
            else if (i < haystacklength && haystack.charAt(i) != needle.charAt(j)) {
                if (j!= 0){
                    j = LPS[j-1] ;
                }
                else {
                    ++i ;
                }
            }
        }
        return -1 ;
    }

    public Set<Integer> allStrStr(String haystack, String needle) {
        if (needle.length() == 0) return null ;
        if (haystack.length() == 0) return null ;
        int [] LPS = new int[needle.length()] ;
        computeLPS(LPS, needle) ;
        Set<Integer> res = new HashSet<>() ;
        int i = 0 ;
        int j = 0 ;
        int needlelength = needle.length() ;
        int haystacklength = haystack.length() ;

        while (i < haystacklength) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++j ;
                ++i ;
            }
            if (j == needlelength) {
                res.add(i -j) ;
               // return (i -j) ;
                j = LPS[j-1] ;
            }
            else if (i < haystacklength && haystack.charAt(i) != needle.charAt(j)) {
                if (j!= 0){
                    j = LPS[j-1] ;
                }
                else {
                    ++i ;
                }
            }
        }
        return res ;
    }

    public void computeLPS (int [] LPS, String pattern) {
        int patlength = pattern.length() ;
        int len = 0 ;
        int i = 1 ;
        LPS[0] = 0 ;

        while (i < patlength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                ++len ;
                LPS[i] = len ;
                ++i ;
            }
            else {
                if (len != 0) {
                    len = LPS[len-1] ;
                }
                else {
                    LPS[i] = len ;
                    ++i ;
                }
            }
        }
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr() ;
        System.out.println (strStr.strStr("hhsadbutsad", "sad" ) ) ;
        System.out.println(strStr.allStrStr("hhsadbutsad", "sad"));
    }

}
