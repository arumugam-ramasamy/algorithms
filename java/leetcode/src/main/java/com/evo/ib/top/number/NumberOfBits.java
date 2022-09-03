package com.evo.ib.top.number;

public class NumberOfBits {
    public int hammingWeight(int n) {

        if (n == 0) return 0;
        int bitOne = 1;
        int no1bits = 0 ;
        for (int i = 0; i < 32; i++) {
            if (n == 0) return no1bits ;
             if (i != 0)
                 n = n>> 1 ;
             no1bits += bitOne & n ;
        }
        return  no1bits ;
    }
}
