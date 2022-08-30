package com.evo.ib.cryptarith;


// Java program for the above approach
import java.io.*;
import java.util.*;

class GFG {

    // Function to check if the
    // assignment of digits to
    // characters is possible
    public static boolean isSolvable(String[] words,
                                     String result)
    {
        // Stores the value
        // assigned to alphabets
        int mp[] = new int[26];

        // Stores if a number
        // is assigned to any
        // character or not
        int used[] = new int[10];

        // Stores the sum of position
        // value of a character
        // in every string
        int Hash[] = new int[26];
        int count = 0 ;

        // Stores if a character
        // is at index 0 of any
        // string
        int CharAtfront[] = new int[26];

        Arrays.fill(mp, -1);
        Arrays.fill(used, 0);
        Arrays.fill(Hash, 0);
        Arrays.fill(CharAtfront, 0);

        // Stores the string formed
        // by concatenating every
        // occurred character only
        // once
        StringBuilder uniq = new StringBuilder();

        // Iterator over the array,
        // words
        for (String word : words) {

            // Iterate over the string,
            // word
            for (int i = 0; i < word.length(); i++) {

                // Stores the character
                // at ith position
                char ch = word.charAt(i);

                // Update Hash[ch-'A]
                Hash[ch - 'A'] += (int)Math.pow(
                        10, word.length() - i - 1);

                // If mp[ch-'A'] is -1
                if (mp[ch - 'A'] == -1) {

                    mp[ch - 'A'] = 0;
                    uniq.append((char)ch);
                }

                // If i is 0 and word
                // length is greater
                // than 1
                if (i == 0 && word.length() > 1) {

                    CharAtfront[ch - 'A'] = 1;
                }
            }
        }

        // Iterate over the string result
        for (int i = 0; i < result.length(); i++) {

            char ch = result.charAt(i);

            Hash[ch - 'A'] -= (int)Math.pow(
                    10, result.length() - i - 1);

            // If mp[ch-'A] is -1
            if (mp[ch - 'A'] == -1) {
                mp[ch - 'A'] = 0;
                uniq.append((char)ch);
            }

            // If i is 0 and length of
            // result is greater than 1
            if (i == 0 && result.length() > 1) {
                CharAtfront[ch - 'A'] = 1;
            }
        }

        Arrays.fill(mp, -1);

        // Recursive call of the function
        boolean ans =  solve(uniq, 0, 0, mp, used, Hash,
                CharAtfront, count);
        if (ans) count += 1;
        System.out.println ("Count is " + count) ;
        return ans ;
    }

    // Auxiliary Recursive function
    // to perform backtracking
    public static boolean solve(
            StringBuilder words, int i,
            int S, int[] mp, int[] used,
            int[] Hash,
            int[] CharAtfront, int count)
    {
        // If i is word.length
        if (i == words.length())

            // Return true if S is 0
            return (S == 0);

        // Stores the character at
        // index i
        char ch = words.charAt(i);

        // Stores the mapped value
        // of ch
        int val = mp[words.charAt(i) - 'A'];

        // If val is -1
        if (val != -1) {

            // Recursion
            boolean ans =  solve(words, i + 1,
                    S + val * Hash[ch - 'A'],
                    mp, used,
                    Hash, CharAtfront, count);
            if (ans) count+= 1 ;
            System.out.println ("Count value " + count) ;
            return ans ;
        }

        // Stores if there is any
        // possible solution
        boolean x = false;

        // Iterate over the range
        for (int l = 0; l < 10; l++) {

            // If CharAtfront[ch-'A']
            // is true and l is 0
            if (CharAtfront[ch - 'A'] == 1
                    && l == 0)
                continue;

            // If used[l] is true
            if (used[l] == 1)
                continue;

            // Assign l to ch
            mp[ch - 'A'] = l;

            // Marked l as used
            used[l] = 1;

            // Recursive function call
            boolean ans = solve(words, i + 1,
                    S + l * Hash[ch - 'A'],
                    mp, used, Hash, CharAtfront, count);
          if (ans == true) {
              count += 1 ;
              System.out.println ("Count value " + count);
            }

            x |= ans ;

            // Backtrack
            mp[ch - 'A'] = -1;

            // Unset used[l]
            used[l] = 0;
        }

        // Return the value of x;
        return x;
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Input
        String[] arr
                = { "SEND", "MORE" };
        String S = "MONEY";

        // Function Call
        if (isSolvable(arr, S))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}