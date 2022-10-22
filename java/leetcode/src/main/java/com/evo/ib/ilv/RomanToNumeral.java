package com.evo.ib.ilv;

import java.util.HashMap;
import java.util.Map;
/*
 * Click `Run` to execute the snippet below!
 */



/*
Given a Roman numeral, the task is to find its corresponding decimal value.

Example :

Input: IX
Output: 9
IX is a Roman symbol which represents 9

Input: XL
Output: 40
XL is a Roman symbol which represents 40

Input: MCMIV
Output: 1904
M is a thousand,
CM is nine hundred and
IV is four
Roman numerals are based on the following symbols.

SYMBOL       VALUE
  I            1
  IV           4
  V            5
  IX           9
  X            10
  XL           40
  L            50
  XC           90
  C            100
  CD           400
  D            500
  CM           900
  M            1000

  Be concerned only for input number ranges 1 - 1999
 */

public class RomanToNumeral {

    public static void main(String[] args) {
    /*
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
    */

        System.out.println("Roman Number value for  XIV - " +
                romantoNumeral("XIV"));
        System.out.println("Roman Number value for  MMXXII - " +
                romantoNumeral("MMXXII"));
        System.out.println("Roman Number value for  MCMLXXIX- " +
                romantoNumeral("MCMLXXIX"));
    }


    public static int romantoNumeral(String str) {
        Map<Character, Integer> romanValue = new HashMap<>();
        int number = 0;
        if (str == null || str.length() == 0) return number;
        romanValue.put('I', 1);
        romanValue.put('V', 5);
        romanValue.put('X', 10);
        romanValue.put('L', 50);
        romanValue.put('C', 100);
        romanValue.put('D', 500);
        romanValue.put('M', 1000);

        int i = 0;
        int len = str.length();
        while (i < len) {

            switch (str.charAt(i)) {

                case 'I':
                case 'X':
                case 'C':
                    char curCh = str.charAt(i) ;
                    char nextCh = ' ' ;
                    if (i+1 < len) {
                        nextCh = str.charAt(i+1) ;
                    }
                    int add= romanValue.get(curCh) ;
                    if (nextCh != ' ') {
                        if (romanValue.get(nextCh) > romanValue.get(curCh)) {
                            add = (romanValue.get(nextCh) -add) ;
                            i+= 2 ;
                        }
                        else {
                            ++i ;
                        }
                    } else {
                        ++i;
                    }
                    number += add ;
                    break;
                case 'V':
                case 'L' :
                case 'D' :
                case 'M':
                    number += romanValue.get(str.charAt(i));
                    ++i;
                    break;
                default:
                    System.out.println("Unknown roman numeral");
                    return -1;
            }
        }

        return number;
    }

}

