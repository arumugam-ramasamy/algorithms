package com.smic.practice.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stack <T> {
    List<T>  stackList ;
    int curPos ;
    int MAX_SIZE ;


    Stack() {
        stackList = new ArrayList<>(15);
        curPos = - 1 ;
        MAX_SIZE = 15 ;
    }

    public List<T> getStackList() {
        return stackList;
    }

    public void setStackList(List<T> stackList) {
        this.stackList = stackList;
    }

    public int getCurPos() {
        return curPos;
    }

    public void setCurPos(int curPos) {
        this.curPos = curPos;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public void setMAX_SIZE(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    public boolean push(T data) {
        if ((curPos+1) < MAX_SIZE) {
            stackList.add(data);
            ++curPos ;
            return true ;
        }
        else {
            System.out.println("MAX STACK REACHED");
            return false ;
        }
    }

    public T peek () {
        if (curPos >= 0) {
            return stackList.get(curPos) ;
        }
        return null ;
    }

    public T pop () {
        if (curPos < 0) {
            System.out.println("STACK is empty");
            return null ;
        }
        T data = stackList.get(curPos) ;
        --curPos ;
        return (data) ;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>() ;
        Random rand = new Random() ;
        for (int i = 0 ; i < 16 ; i++) {
            int val = rand.nextInt(100) ;
            System.out.println(val);
            stack.push(val) ;
        }
        for (int i = 0 ; i < 16 ; i++)
            System.out.println(stack.pop());

        Stack<String> stackstr = new Stack<>() ;
        stackstr.push("hello");
        stackstr.push("you");
        stackstr.push("there") ;
        System.out.println(stackstr.pop());
        System.out.println(stackstr.pop());
        System.out.println(stackstr.pop());


    }
}
