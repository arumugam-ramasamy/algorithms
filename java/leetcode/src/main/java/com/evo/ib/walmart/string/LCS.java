package com.evo.ib.walmart.string;

import java.util.HashMap;
import java.util.Map;

class LCS {

    // Function to find the length of the longest common subsequence of substring
    // `X[0…m-1]` and `Y[0…n-1]`
    public static int LCSLength(String X, String Y, int m, int n,
                                Map<String, Integer> lookup) {
        // return if the end of either string is reached
        if (m == 0 || n == 0) {
            return 0;
        }

        // construct a unique map key from dynamic elements of the input
        String key = m + "|" + n;

        // if the subproblem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key)) {
            // if the last character of `X` and `Y` matches
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lookup.put(key, LCSLength(X, Y, m - 1, n - 1, lookup) + 1);
            } else {
                // otherwise, if the last character of `X` and `Y` don't match
                lookup.put(key, Integer.max(LCSLength(X, Y, m, n - 1, lookup),
                        LCSLength(X, Y, m - 1, n, lookup)));
            }
        }

        // return the subproblem solution from the map
        return lookup.get(key);
    }
    /*
       Returns length of longest common substring
       of X[0..m-1] and Y[0..n-1]
    */
    public int longestCommonSubsequence(String text1, String text2) {
        Map<String, Integer> lookup = new HashMap<>();

        return (LCSLength(text1, text2, text1.length(), text2.length(), lookup));



    }
    static int LCSubStr(char X[], char Y[],
                        int m, int n)
    {
        // Create a table to store
        // lengths of longest common
        // suffixes of substrings.
        // Note that LCSuff[i][j]
        // contains length of longest
        // common suffix of
        // X[0..i-1] and Y[0..j-1].
        // The first row and first
        // column entries have no
        // logical meaning, they are
        // used only for simplicity of program
        int LCStuff[][] = new int[m + 1][n + 1];

        // To store length of the longest
        // common substring
        int result = 0;

        // Following steps build
        // LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                {
                    LCStuff[i][j]
                            = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result,
                            LCStuff[i][j]);
                }
                else
                    LCStuff[i][j] = 0;
            }
        }
        return result;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        System.out.println(LCSubStr(X.toCharArray(),
                Y.toCharArray(), m,
                n));
    }
}
