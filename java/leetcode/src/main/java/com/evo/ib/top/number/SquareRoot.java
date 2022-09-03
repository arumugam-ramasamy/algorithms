package com.evo.ib.top.number;

public class SquareRoot {

    public static int mySqrt(int n) {
        double val = squareRoot((double) n, 0.9) ;
        return (int) val ;
    }
    public static double squareRoot(double n, double l) {
        if (n <= 0) return 0 ;
        // Assuming the sqrt of n as n only
        double x = n;

        // The closed guess will be stored in the root
        double root;

        // To count the number of iterations
        int count = 0;

        while (true) {
            count++;

            // Calculate more closed x
            root = 0.5 * (x + (n / x));

            // Check for closeness
            if (Math.abs(root - x) < l)
                break;

            // Update root
            x = root;
        }
        System.out.println (count) ;
        return root;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(110000000));
    }
}
