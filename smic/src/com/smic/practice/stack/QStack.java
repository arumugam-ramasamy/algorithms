package com.smic.practice.stack;

import java.util.Random;

public class QStack <T> {
    Stack<T> queue ;
    Stack<T> dequeue ;

    QStack() {
        queue = new Stack<>() ;
        dequeue = new Stack<>() ;
    }

    public void addQueue (T data) {
        boolean ret = queue.push(data) ;
        if (ret == false) {
            System.out.println ("Max queue count reached ") ;
        }
    }

    public T dequeueElem () {
        if (dequeue.getCurPos() >= 0) {
            return dequeue.pop() ;
        }
        while (queue.getCurPos() >= 0 ) {
            T data = queue.peek() ;
            if (data != null)
                dequeue.push (queue.pop()) ;
            else {
                System.out.println ("No more element available for dequeue") ;
                return null;
            }
        }
        if (dequeue.getCurPos() >= 0)
            return dequeue.pop() ;
        return null ;
    }

    public static void main(String[] args) {
        QStack <Integer>  test = new QStack<>();
        test.addQueue(1);
        test.addQueue(2);
        test.addQueue(3);
        test.addQueue(4);
        System.out.println(test.dequeueElem() ) ;
        System.out.println(test.dequeueElem() ) ;
        Random rand = new Random() ;
        for (int i = 0 ; i < 15 ; i++) {
            test.addQueue(rand.nextInt(100)) ;
        }
        for (int i = 0 ; i < 18 ; i++) {
            System.out.println(test.dequeueElem() ) ;
        }
    }
}
