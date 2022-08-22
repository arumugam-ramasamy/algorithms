package com.evo.ib.google.ArrAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceParens {

    public static boolean balanceParens (String s) {
        if (s == null) return true ;
        Map<Character, Character> matchingparens = new HashMap<>() ;
        matchingparens.put('}', '{') ;
        matchingparens.put(']', '[') ;
        matchingparens.put(')', '(') ;
        Stack<Character> stackparens = new Stack<>()  ;
        for (int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            if (ch == ')' || ch == '}' || ch == ']') {
                if (stackparens.isEmpty()) return false ;
                if (stackparens.pop() != matchingparens.get(ch))
                    return false ;
            }
            if (ch == '(' || ch == '{' || ch == '[') stackparens.push(ch) ;
        }
        return stackparens.isEmpty() ;

    }

    public static void main(String[] args) {
        System.out.println(balanceParens("((((()))))") ) ;
        System.out.println(balanceParens( "[(sdfsaf)]{}{[(dsfdsa)()]ewirew83i()}”"));
        System.out.println (balanceParens("[(])")) ;
        System.out.println(balanceParens("["));
        System.out.println(balanceParens("]"));

    }
}
