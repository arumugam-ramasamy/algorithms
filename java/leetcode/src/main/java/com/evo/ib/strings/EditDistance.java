package com.evo.ib.strings;

public class EditDistance {

    public static boolean isEditDistanceOne (String str1, String str2) {
        if (str1 == null && str2 == null) return false ;
        if (str1.length() == 0 && str2.length() == 0) return false ;
        if ((str1 == null || str1.length() == 0) && str2.length() == 1) return true ;
        if ((str2 == null || str2.length() == 0) && str1.length() == 1) return true ;
        if (str1 == null || str2 == null) return false ;
        int lenDiff = Math.abs(str1.length() - str2.length()) ;
        if (lenDiff > 1) return false ;

        int editDistance = 0 ;

        for (int i = 0 , j = 0 ; i < str1.length() && j < str2.length() ; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) editDistance++ ;
            if (editDistance > 1) return false ;
        }
        if (editDistance <= 1 && lenDiff == 0) return true ;
        if (editDistance == 0 && lenDiff == 1) return true ;
        return false ;
    }

    static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    static int editDistRec(String str1, String str2, int m,
                        int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same,
        // nothing much to do. Ignore last characters and
        // get count for remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return editDistRec(str1, str2, m - 1, n - 1);

        // If last characters are not same, consider all
        // three operations on last character of first
        // string, recursively compute minimum cost for all
        // three operations and take minimum of three
        // values.
        return 1
                + min(editDistRec(str1, str2, m, n - 1), // Insert
                editDistRec(str1, str2, m - 1, n), // Remove
                editDistRec(str1, str2, m - 1,
                        n - 1) // Replace
        );
    }

    static int editDistDP(String str1, String str2, int m,
                          int n)
    {
        // Create a table to store results of subproblems
        int dp[][] = new int[m + 1][n + 1];

        // Fill d[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is
                // to insert all characters of second string
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j

                    // If second string is empty, only option is
                    // to remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last
                    // char and recur for remaining string
                else if (str1.charAt(i - 1)
                        == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If the last character is different,
                    // consider all possibilities and find the
                    // minimum
                else
                    dp[i][j] = 1
                            + min(dp[i][j - 1], // Insert
                            dp[i - 1][j], // Remove
                            dp[i - 1]
                                    [j - 1]); // Replace
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
        String s1 = "gcggggggga";
        String s2 = "gcgggggga";
        if(isEditDistanceOne(s1, s2))
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println(editDistRec(s1, s2, s1.length(), s2.length()));
        System.out.println(editDistDP(s1, s2, s1.length(), s2.length()));
    }
}
