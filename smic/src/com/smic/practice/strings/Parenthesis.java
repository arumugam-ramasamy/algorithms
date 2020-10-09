package com.smic.practice.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parenthesis {
    static Map<Character,Character> parens = new HashMap<>() ;
    final static String leftParenlist = "([{" ;
    final static String rightParenlist = ")}]" ;

    public static void initParens ()  {
        parens.put('}', '{') ;
        parens.put(']', '[') ;
        parens.put(')', '(') ;
    }

    public static boolean balanceParens (String str) {
        Stack<Character> parenStack = new Stack<>() ;
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                parenStack.push(str.charAt(i)) ;
            }
            if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {
                if (parenStack.empty()) return false ;
                if (parens.get(str.charAt(i)) != parenStack.pop()) {
                    return false ;
                }
            }
        }
        return  true ;
    }

    public static void main(String[] args) {
        initParens();
        System.out.println(balanceParens("((((()))))") ) ;
        System.out.println(balanceParens( "[(sdfsaf)]{}{[(dsfdsa)()]ewirew83i()}”"));
        System.out.println (balanceParens("[(])")) ;

    }
}
