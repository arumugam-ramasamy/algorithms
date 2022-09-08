package com.evo.ib.bt;


public class BTreePrinterTest {

    private static RandomNode<Integer> test1() {
        RandomNode<Integer> root = new RandomNode<Integer>(2);
        RandomNode<Integer> n11 = new RandomNode<Integer>(7);
        RandomNode<Integer> n12 = new RandomNode<Integer>(5);
        RandomNode<Integer> n21 = new RandomNode<Integer>(2);
        RandomNode<Integer> n22 = new RandomNode<Integer>(6);
        RandomNode<Integer> n23 = new RandomNode<Integer>(3);
        RandomNode<Integer> n24 = new RandomNode<Integer>(6);
        RandomNode<Integer> n31 = new RandomNode<Integer>(5);
        RandomNode<Integer> n32 = new RandomNode<Integer>(8);
        RandomNode<Integer> n33 = new RandomNode<Integer>(4);
        RandomNode<Integer> n34 = new RandomNode<Integer>(5);
        RandomNode<Integer> n35 = new RandomNode<Integer>(8);
        RandomNode<Integer> n36 = new RandomNode<Integer>(4);
        RandomNode<Integer> n37 = new RandomNode<Integer>(5);
        RandomNode<Integer> n38 = new RandomNode<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static RandomNode<Integer> test2() {
        RandomNode<Integer> root = new RandomNode<Integer>(2);
        RandomNode<Integer> n11 = new RandomNode<Integer>(7);
        RandomNode<Integer> n12 = new RandomNode<Integer>(5);
        RandomNode<Integer> n21 = new RandomNode<Integer>(2);
        RandomNode<Integer> n22 = new RandomNode<Integer>(6);
        RandomNode<Integer> n23 = new RandomNode<Integer>(9);
        RandomNode<Integer> n31 = new RandomNode<Integer>(5);
        RandomNode<Integer> n32 = new RandomNode<Integer>(8);
        RandomNode<Integer> n33 = new RandomNode<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {

        BTreePrinter.printNode(test1());
        BTreePrinter.printNode(test2());

    }
}

