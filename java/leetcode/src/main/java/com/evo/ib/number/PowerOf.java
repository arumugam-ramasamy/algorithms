package com.evo.ib.number;

public class PowerOf {
    public static boolean powerOf (int thisOne, int thatOne) {
        if (thisOne == 0 || thatOne == 0) return false ;
        double thisOneLog = Math.log((double) thisOne) ;
        double thatOneLog = Math.log((double) thatOne) ;
        double divLog = 0.0 ;
        if (thatOne > thisOne) {
            divLog = thatOneLog / thisOneLog ;
        }
        else {
            divLog = thisOneLog / thatOneLog ;
        }

        if ((divLog - ((double) ((int) divLog))) == 0.0) {
            return true ;
        }
        return false ;
    }

    public static void main(String[] args) {
        System.out.println(powerOf(3, 9));
        System.out.println(powerOf(16, 4));
        System.out.println(powerOf(3, 15));
        System.out.println(powerOf(16, 16 * 16 * 16 * 16)) ;
    }
}
