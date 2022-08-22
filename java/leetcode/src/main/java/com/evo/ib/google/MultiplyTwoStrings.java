package com.evo.ib.google;

public class MultiplyTwoStrings {

    public String multiply(String num1, String num2) {

        boolean negative = false ;
        if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            negative = true ;
            num1 = num1.substring(1) ;
        }
        if (num1.charAt(0) != '-' && num2.charAt(0) == '-') {
            negative = true ;
            num2 = num2.substring(1) ;
        }
        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            num1 = num1.substring(1) ;
            num2 = num2.substring(1) ;
        }
       // num1 = new StringBuffer(num1).reverse().toString() ;
       // num2 = new StringBuffer(num2).reverse().toString() ;
        int [] res = new int[num1.length() + num2.length()] ;
        int resi = num1.length()-1 ;
        int resj = num2.length()-1;
        int restotal = resi+ resj ;
        int resindex ;
        for (int i = num1.length()-1 ; i >= 0 ; i--) {
            for (int j = num2.length()-1; j >= 0 ; j--) {
                resindex = restotal-i -j ;
                res[resindex] = res[resindex] + (num1.charAt(i) - '0') *
                        (num2.charAt(j) - '0') ;
            }
        }

        String product = new String() ;

        int digit = 0 ;
        int carry = 0 ;
        for (int i = 0 ; i < res.length ; i++) {
            digit = res[i] %10 ;
            carry = res[i] / 10 ;
            if (i+1 < res.length) {
                res[i+1] = res[i+1] + carry ;
            }
            product = digit + product ;
        }
        while (product.length() > 1
                && product.charAt(0) == '0') {
            product = product.substring(1);
        }
        if (negative) {
            product = new StringBuffer(product)
                    .insert(0, '-')
                    .toString();
        }
        return product ;
    }
}
