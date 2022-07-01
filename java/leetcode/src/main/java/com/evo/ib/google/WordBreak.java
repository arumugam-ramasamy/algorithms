package com.evo.ib.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static Set<String> setofDictWords = new HashSet<>() ;
    public static boolean wordBreak(String s, List<String> dictionary) {
        // create a dp table to store results of subproblems
        // value of dp[i] will be true if string s can be segmented
        // into dictionary words from 0 to i.
        boolean[] dp = new boolean[s.length() + 1];

        // dp[0] is true because an empty string can always be segmented.
        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && setofDictWords.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreakRec (String word) {

        if (word.length() == 0 ) return true ;
        boolean [] wp  = new boolean[word.length()+1] ;

        for (int i = 1 ; i < word.length() ; i++) {

            if (wp[i] == false && setofDictWords.contains(word.substring(0, i))){
                wp[i] = true ;
            }
            if (wp[i] == true) {
                if (i == word.length()) return true;

                for (int j = i + 1; j <= word.length(); j++) {
                    if (wp[j] == false && setofDictWords.contains(word.substring(i, j))) {
                        wp[j] = true;
                    }

                    if (wp[j] == true) {
                        if (j == word.length()) return true;
                    }
                }
            }

        }
        return false ;

    }


    public static void main(String[] args) {
        String[] dictionary = {"mobile", "samsung", "sam", "sung", "man",
                "mango", "icecream", "and", "go", "i",
                "like", "ice", "cream"};

        List<String> dict = new ArrayList<>();
        for (String s : dictionary) {
            dict.add(s);
        }

        for (String s : dictionary) {
            setofDictWords.add(s) ;
        }

        if (wordBreakRec("ilikesamsung")) {
            System.out.println("Rec Yes");
        } else {
            System.out.println("No");
        }

        if (wordBreak("ilikesamsung", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("iiiiiiii", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("samsungandmango", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("ilikesamsung", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak("samsungandmangok", dict)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
