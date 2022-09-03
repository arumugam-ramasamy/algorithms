package com.evo.ib.top.strings;

public class ExcelToNumber {
    public static int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) return 0 ;
        long power = 1 ;
        long sum = 0 ;
        for (int i = 0 ; i < columnTitle.length() ; i++) {
            sum = sum * 26 + ((int) columnTitle.charAt(i) -64) ;
        }
        return (int) sum ;

    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
