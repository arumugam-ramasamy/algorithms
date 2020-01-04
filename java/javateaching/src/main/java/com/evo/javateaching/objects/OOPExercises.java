package com.evo.javateaching.objects;

import java.io.ObjectOutputStream;

public class OOPExercises {
    public static void eercises1() {
        A objA = new A();
        System.out.println("in main(): ");
        System.out.println("objA.a = "+  objA.getA() ) ; // objA.a);
        objA.setA(222);   // objA.a = 222;
    }

    public static void exercises2() {
        A objA = new A() ;
        System.out.println("in main(): ");
        System.out.println("objA.a = "+  objA.getA() ) ;    // getA() );
        objA.setA(123); // setA(123);
    }

    public static void exercises3 () {
        A objA = new A( );
        double result;
        result = objA.getA( );
        System.out.println("objA.a = "+ result);
    }

    public static void main(String[] args) {

        OOPExercises.eercises1();
        OOPExercises.exercises2();

    }
}