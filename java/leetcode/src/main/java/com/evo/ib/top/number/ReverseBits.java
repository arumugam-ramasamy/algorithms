package com.evo.ib.top.number;

public class ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        if (n == 0) return 0 ;
        int rev = 0;

        // traversing bits of 'n'
        // from the right
        int i = 0 ;
        while (i < 32)
        {
            // if current bit is '1'
            if ((n & 1) == 1)
                rev |= 1;

            // bitwise left shift
            // 'rev' by 1
            i++ ;
            if (i == 32)break ;
            rev <<= 1;


            // bitwise right shift
            //'n' by 1
            n >>= 1;
        }
        // required number
        return rev;
    }
}
