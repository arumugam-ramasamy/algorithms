package com.evo.ib.usbank.strings;

public class String2D {
    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static boolean stringFind2D(char[][] letters, String str) {
        for (int row = 0 ; row < letters.length ; row++) {
            for (int col = 0 ; col < letters[0].length ; col++) {
                if (letters[row][col] == str.charAt(0) &&
                patternSearch(letters, str, row, col))
                    return true ;
            }
        }
        return false ;
    }

    public static boolean patternSearch (char[][] letters, String str,  int row, int col) {
       if (letters[row][col] != str.charAt(0)) return false ;
       for (int i = 0 ; i < x.length ;  i++) {
           int k, rd = row+x[i],cd = col+y[i] ;
           for (k = 1 ;  k < str.length() ; k++) {
               if (rd >= letters.length || cd >= letters[0].length || rd < 0 || cd < 0)
                   break ;
               if (letters[rd][cd] != str.charAt(k)) break ;
               rd = x[i] + rd ;
               cd = y[i] + cd ;
           }
           if (k == str.length()) return true ;
       }
       return false ;
    }

    public static void main(String[] args) {

        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
        System.out.println(stringFind2D(grid, "GEEKSS"));
        System.out.println();
        System.out.println(stringFind2D(grid, "KFD"));
    }

}
