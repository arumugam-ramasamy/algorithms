package com.smic.practice.strings;

public class RemoveChars {
    public static String removeChars(String str, char ch) {
        if (str == null || str.length() == 0) return str ;
        char [] letters = str.toCharArray() ;
        StringBuilder sb = new StringBuilder( );

        for (char let : letters) {
            if (let != ch) {
                sb.append(let) ;
            }
        }
        return  sb.toString() ;
    }

    public static String removeRecChars (String str, char ch) {
        if (str == null || str.length() == 0) return str ;
        int index = str.indexOf(ch) ;
        if (index == -1) return str ;
        return (str.substring(0, index) + removeRecChars(str.substring(index+1, str.length()), ch)) ;
    }
}
