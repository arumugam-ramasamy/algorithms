package com.evo.ib.google.test;

import java.util.Stack;

public class BackSpace {
    public static boolean backspaceCompare(String s, String t) {
            if ((s == null || s.length() == 0) &&
                    (t == null || t.length() == 0))
                return true ;
            if ((s == null || s.length() == 0) ||
                    (t == null || t.length() == 0))
                return false;
        Stack <Character> stackS = new Stack<>() ;
        Stack <Character> stackT = new Stack<>() ;

        for (int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) != '#')
                stackS.push(s.charAt(i)) ;
            else {
                if (stackS.isEmpty()) {
                    System.out.println("Error in input backspace without chracter");
                }
                else stackS.pop() ;
            }
        }

        for (int i = 0 ; i < t.length() ; i++) {
            if(t.charAt(i) != '#')
                stackT.push(t.charAt(i)) ;
            else {
                if (stackT.isEmpty()) {
                    System.out.println("Error in input backspace without chracter");
                }
                else stackT.pop() ;
            }
        }

        if (stackS.size() != stackT.size()) return false ;

        while (stackS.size() > 0) {
            if (stackS.pop() != stackT.pop()) return false ;
        }

       return true ;
    }

}
