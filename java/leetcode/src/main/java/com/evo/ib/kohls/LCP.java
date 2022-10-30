package com.evo.ib.kohls;

/*
Program :

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LCP {

    public static String lcp (String [] words) {
        if (words == null) return null ;
        if (words.length == 0) return "" ;
        if (words.length == 1) return words[0] ;
        String prefix = "" ;
        Trie trie = new Trie() ;
        for (String word : words)
            trie.insert(word) ;

        prefix = trie.prefix() ;
        return prefix ;
    }

    public static boolean  testEmpty () {
        String [] words = new String[0] ;
        if (lcp (words) == null) return true ;
        if (lcp (words).length() == 0) return true ;
        return false ;
    }

    public static boolean testOne () {
        String [] words = new String[1] ;
        words[0] = "one" ;
        if (lcp(words).equals(words[0])) return true ;
        return false ;
    }

    public static boolean testMultipleSucees () {
        String[] words = {"flower", "flow", "flight"};
        // assert
        if (lcp(words).equals("fl"))
            return true;
        else
            return false;

    }

    public static boolean testFailure () {
        String[] noprefix = {"dog", "racecar", "car"};
        if (lcp(noprefix).equals("")) return true;
        return false ;
    }

    public void cleanInput (String []  words ) {

    }

    public static void main(String[] args) {
        System.out.println(testMultipleSucees()) ;
        System.out.println (testFailure()) ;
        System.out.println (testEmpty()) ;
        System.out.println(testOne());
    }


}
