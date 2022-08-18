package com.evo.ib.ns;

public class ConvertDecimalToBinary {

    public static String convertitb (int allval) {
        if (allval >= 0) return convertdtb(allval) ;
        String posstr = convertdtb(allval * -1) ;
        return (twosComplement(posstr)) ;
    }

    public static String twosComplement (String posstr) {
        StringBuilder sb = new StringBuilder() ;
        String onec = OneComplement(posstr) ;
        int i = posstr.length()-1 ;
        int carry = 1 ;
        while (i >= 0){
            if (onec.charAt(i) == '0') {
                if (carry == 1) {
                    sb.append("1");
                    carry = 0;
                }
                break ;
            }
            else {
                sb.append("0") ;
                carry = 1 ;
            }
            i-- ;
        }
        i-- ;
        while (i >= 0) {
            sb.append(onec.charAt(i));
            i--;
        }
        return  sb.reverse().toString() ;


    }

    public static String OneComplement (String posstr) {
        StringBuilder sb = new StringBuilder() ;
        for (int i = 0 ; i < posstr.length() ; i++) {
            if (posstr.charAt(i) == '1')
                sb.append("0") ;
            else {
                sb.append("1") ;
            }
        }
        return  sb.toString() ;
    }
    public static String convertdtb (int dec) {
        StringBuilder sb = new StringBuilder() ;

        if (dec < 2) return Integer.toString(dec) ;
        while (dec >= 2) {
            sb.append( Integer.toString(dec % 2) ) ;
            dec = dec / 2 ;
        }
        if (dec == 1) sb.append("1") ;
        for (int i = sb.length() ; i < 32 ; i++)
            sb.append("0") ;

        return sb.reverse().toString() ;
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
        int testnegative = -1000 ;
        int testpositive = 101 ;
        System.out.println(testpositive + " in binary is " + convertdtb(testpositive));
        System.out.println(convertdtb(testpositive)  + " back to decimal is " +
                convertbtd( convertdtb(testpositive)));

        System.out.println(bitsInInteger(testnegative));
        System.out.println(Integer.toBinaryString(testnegative));
        System.out.println(convertitb(testnegative));
    }
}
