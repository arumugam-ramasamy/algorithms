package com.evo.ib.disney.strings;

public class ReverseWords {

    public static String reverseWordsInSentence(String sentence) {
        if (sentence == null || sentence.trim().length() == 0) return null ;
        sentence = sentence.trim() ;
        StringBuilder sb = new StringBuilder() ;
        String [] words = sentence.split(" ") ;
        sb.append(words[words.length-1]) ;
        for (int i = words.length-2 ; i >= 0 ; i--) {
            if (words[i].trim().length() != 0) {
                sb.append(" ") ;
                sb.append(words[i]) ;
            }
        }
        return sb.toString() ;
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInSentence("Welcome to       Alva"));
    }

}
