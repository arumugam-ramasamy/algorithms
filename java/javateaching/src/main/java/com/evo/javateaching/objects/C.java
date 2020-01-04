package com.evo.javateaching.objects;

public class C  extends A {

    public C() {
        System.out.println(" The default constructor of C is called ");
    }

    public C(int i) {
        super(i);
    }

    @Override
    public void overridethis() {
        System.out.println ("This is overridethis function in C")
    }
}
