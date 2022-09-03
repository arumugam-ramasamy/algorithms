package com.evo.ib.top.stack;


import java.util.Stack;

class MaxStack {
    Stack<Integer> stack ;
    Stack<Integer> maxStack ;

    public MaxStack() {
        stack = new Stack<>() ;
        maxStack = new Stack<>() ;
    }

    public void push(int x) {
        stack.push(x );
        if (maxStack.isEmpty() || x >= maxStack.peek())
            maxStack.push(x) ;

    }

    public int pop() {
        int val = stack.pop() ;
        if (val == maxStack.peek())
            maxStack.pop() ;
        return val ;
    }

    public int top() {
        return stack.peek() ;
    }

    public int peekMax() {
        return maxStack.peek() ;
    }

    public int popMax() {
        int val = maxStack.peek() ;
        while (stack.peek() != val) stack.pop() ;
        maxStack.pop() ;
        return val ;

    }
}
