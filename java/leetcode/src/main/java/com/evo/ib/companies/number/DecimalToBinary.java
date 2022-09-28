package com.evo.ib.companies.number;

public class DecimalToBinary {
    public static String decimalToBinary(float value, int precision) {
        StringBuilder sb = new StringBuilder() ;
        if (value == 0.0) return "0.0" ;
        int dec = (int) value ;
        value = value - (float) dec ;
        while (dec >= 2) {
            int rem = dec % 2 ;
            dec = dec/2 ;
            sb.append(rem) ;
        }
        if (dec == 1) sb.append(dec) ;
        String descStr = sb.reverse().toString() ;
        sb.delete(0, sb.length()) ;
        int count = 0 ;
        while (value != 0.0 && count < precision) {
            value = value * 2.0F;
            if (value < 1.0) {
                sb.append("0") ;
            }
            else {
                sb.append("1") ;
                value = value - 1.0F ;
            }
            count++ ;
        }
        String fractionStr = sb.toString() ;
        return  descStr + "." + fractionStr;
    }

    public static void main(String[] args) {
        float n = 4.47F;
        int k = 3;
        System.out.println(Float.floatToIntBits(n));
        System.out.println(decimalToBinary(n, k));

        n = 6.986F;
        k = 5;
        System.out.println(Float.floatToIntBits(n));
        System.out.println(decimalToBinary(n, k));
    }
}
