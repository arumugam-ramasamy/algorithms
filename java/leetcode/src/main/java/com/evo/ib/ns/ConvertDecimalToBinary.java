package com.evo.ib.ns;

public class ConvertDecimalToBinary {

    public static String convertdtb (int dec) {
        String dtb = "" ;

        if (dec < 2) return Integer.toString(dec) ;
        while (dec >= 2) {
            dtb = Integer.toString(dec % 2) + dtb ;
            dec = dec / 2 ;
        }
        if (dec == 1) dtb = "1" + dtb ;

        return dtb ;
    }

    public static String bitsInInteger (int val) {
        StringBuilder sb = new StringBuilder() ;
        int bit = 1 ;
        for (int i = 0 ; i < 32 ; i++) {
            if ((val  & bit) == 1) {
                sb.append("1") ;
            }
            else {
                sb.append("0") ;
            }
            val >>= 1 ;
        }
        return sb.reverse().toString() ;
    }

    public static Integer convertbtd (String binary) {

        StringBuilder sb = new StringBuilder() ;
        sb.append(binary) ;
        binary = sb.reverse().toString() ;
        int ans = 0 ;
        int power2 = 1 ;
        for (int i = 0 ; i < binary.length() ; i++) {
            int val = binary.charAt(i) == '1' ? 1 : 0 ;
            ans += val * power2 ;
            power2 *= 2 ;
        }
        return ans ;
    }

    public static void main(String[] args) {
        System.out.println(convertdtb(100));
        System.out.println(convertbtd(convertdtb(100)));
        System.out.println(convertdtb(10));
        System.out.println(bitsInInteger(-4));
        System.out.println(Integer.toBinaryString(-4));
    }
}
