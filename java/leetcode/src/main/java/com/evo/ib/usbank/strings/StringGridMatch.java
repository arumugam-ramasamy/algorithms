package com.evo.ib.usbank.strings;

public class StringGridMatch {

    public static boolean stringGridMatch (char [][] letters, String str) {
        // if string is null nothing to find.
        if (str == null) return true ;
        if (letters == null) return false ;
        int nrows = letters.length ;
        int ncols = letters[0].length ;
        if ((nrows * ncols) < str.length()) return false ;

        for (int i = 0 ; i < nrows ; i++) {
            for (int j = 0 ; j < ncols ; j++) {
                if (letters[i][j] == str.charAt(0)) {
                    if (strMatch (letters, str, i, j, nrows, ncols, 0)) {
                        return true ;
                    }
                }
            }
           ;
        }
        return false ;
    }

    public static boolean strMatch (char[][] letters, String str, int i, int j, int nrows, int ncols, int ind) {
        if (ind == str.length())  return true ;
        if (i >= nrows || j >= ncols || i < 0 || j < 0) return false ;
        if (letters[i][j] == str.charAt(ind)) {
            char temp = letters[i][j];
            letters[i][j] = '#' ;

            boolean res =  strMatch(letters, str, i+1, j, nrows, ncols, ind+1) ||
                    strMatch (letters, str, i, j+1, nrows, ncols, ind+1) ||
                    strMatch (letters, str, i-1, j, nrows, ncols, ind+1) ||
                    strMatch (letters, str, i, j-1, nrows, ncols, ind+1)  ;
            letters[i][j] = temp ;
            return res ;
        }
        else
            return false ;
    }

    public static void main(String[] args)
    {
        char grid[][] = { "axmy".toCharArray(),
                "bgdf".toCharArray(),
                "xeet".toCharArray(),
                "raks".toCharArray() };

        // Function to check if word exists or not
        if (stringGridMatch(grid, "geeks"))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
