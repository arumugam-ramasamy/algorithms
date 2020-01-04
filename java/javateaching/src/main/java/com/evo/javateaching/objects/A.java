package com.evo.javateaching.objects;

public class A {

    private int a = 99;
    protected int b = 63 ;

    public A () {
        System.out.println ("This si default A constrocutor") ;
    }
    public A (int i ) {
        System.out.println ("calling constructor A with integer value = " + i) ;
    }

    public void setA( int value) {
        a = value;
    }
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void overridethis() {
        System.out.println("class A function");
    }
}