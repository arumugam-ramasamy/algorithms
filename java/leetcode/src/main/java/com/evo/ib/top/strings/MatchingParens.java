package com.evo.ib.top.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MatchingParens {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true ;
        Map<Character, Character> match = new HashMap<>() ;
        match.put ('}', '{') ;
        match.put(')', '(') ;
        match.put(']', '[') ;
        Stack<Character> pushedChars = new Stack<>() ;
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                pushedChars.push(s.charAt(i)) ;
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (pushedChars.isEmpty()) return false ;
                if ( pushedChars.pop() != match.get(s.charAt(i)))
                    return false ;
            }
        }
        if (!pushedChars.isEmpty()) return false ;
        return true ;
    }
}
