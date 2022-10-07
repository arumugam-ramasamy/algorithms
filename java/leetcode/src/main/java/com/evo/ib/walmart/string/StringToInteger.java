package com.evo.ib.walmart.string;

public class StringToInteger {


    static int addNumbers(int a, int b) {
        return a + b;
    }

    public static Integer stringToNumber(String str) {

        if (str == null) return null;
        str = str.trim();
        if (str.length() == 0) return null ;
        int len = str.length();
        long num = 0;
        long pow = 10;
        boolean sign = false;
        boolean signseen = false;

        boolean numStarted = false;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '-' || ch == '+') {
                if (signseen) return null;
                if (!numStarted) {
                    signseen = true;
                    if (ch == '-') sign = true;
                    continue ;
                }
            }

            if (ch >= '0' && ch <= '9') {
                if (ch == '0' && numStarted == false) return null;
                if (numStarted == false) {
                    num = (ch - '0');
                    numStarted = true;
                } else {
                    num = num * pow + (ch - '0');
                }
            } else {
                if (numStarted) {
                    if (sign) num *= -1L;
                    if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                    if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                    return (int) num;
                } else return null;


            }
        }

        if (sign) num *= -1L;
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) num;

    }


    public static void main(String[] args) {

        System.out.println(stringToNumber("              "));
    }
}

/*
"123" -> 123
"0123" -> not number
"    123.    "  -> 123
"123abs" -> 123
"1234556778912132435647657686". -> max int
"-1234556778912132435647657686". -> min int
"1234+" -> 1234
"--123". -> not number
"++ab123".-> not number
"-      123" ->not a number
"-+.. " -> not a number"
"+123.   abc" -> 123
"          "  -> not number
 */
