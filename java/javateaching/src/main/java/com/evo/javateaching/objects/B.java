package com.evo.javateaching.objects;

public class B extends  A {

    private int a ;

    public B() {
        System.out.println ("B Empty Constructor is called ") ;
    }

    public void overridethis() {
        System.out.println( "overridethis is being ridden in B");
    }
}
