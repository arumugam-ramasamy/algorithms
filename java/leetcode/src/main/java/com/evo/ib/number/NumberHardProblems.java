package com.evo.ib.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberHardProblems {
    public static String largestBySwapParity(String numStr) {

        char[] arr = numStr.toCharArray() ;
        List<Integer> parityCount = new ArrayList<>() ;
        boolean oddParity = false ;
        boolean prevOddParity = false;
        int count = 0 ;
        oddParity = (arr[0] % 2 == 1 );
        prevOddParity = oddParity ;
        count++ ;
        for (int i = 1 ; i < arr.length ; i++) {
            oddParity = (arr[i] % 2 == 1 );
            if (oddParity == prevOddParity) {
                count++ ;
            }
            else {
                parityCount.add(count) ;
                count = 1 ;

            }
            prevOddParity = oddParity ;
        }
        if (count != 0) parityCount.add(count) ;
       StringBuilder sb = new StringBuilder() ;
       int ind = 0 ;
       int k = 0 ;
        while (k < parityCount.size()) {
            int coun = parityCount.get(k );
            if (coun == 1)  {
                sb.append(arr[ind]) ;
                ind++ ;
                k++ ;
                continue ;
            }
            Character [] charr = new Character[coun ] ;
            for (int j = 0 ; j < coun ; j++)
                charr[j] = arr[j+ind] ;
            Arrays.sort(charr, Collections.reverseOrder()) ;
            ind += coun ;
            for (int l = 0 ; l < charr.length ; l++)
            sb.append(charr[l]) ;
            k++ ;
        }

        return (sb.toString()) ;
    }

    public static String smallestBySwapParity(String numStr) {

        char[] arr = numStr.toCharArray() ;
        List<Integer> parityCount = new ArrayList<>() ;
        boolean oddParity = false ;
        boolean prevOddParity = false;
        int count = 0 ;
        oddParity = (arr[0] % 2 == 1 );
        prevOddParity = oddParity ;
        count++ ;
        for (int i = 1 ; i < arr.length ; i++) {
            oddParity = (arr[i] % 2 == 1 );
            if (oddParity == prevOddParity) {
                count++ ;
            }
            else {
                parityCount.add(count) ;
                count = 1 ;

            }
            prevOddParity = oddParity ;
        }
        if (count != 0) parityCount.add(count) ;
        StringBuilder sb = new StringBuilder() ;
        int ind = 0 ;
        int k = 0 ;
        while (k < parityCount.size()) {
            int coun = parityCount.get(k );
            if (coun == 1)  {
                sb.append(arr[ind]) ;
                ind++ ;
                k++ ;
                continue ;
            }
            Character [] charr = new Character[coun ] ;
            for (int j = 0 ; j < coun ; j++)
                charr[j] = arr[j+ind] ;
            Arrays.sort(charr) ;
            ind += coun ;
            for (int l = 0 ; l < charr.length ; l++)
                sb.append(charr[l]) ;
            k++ ;
        }

        return (sb.toString()) ;
    }

    public static void main(String[] args) {
        String num = "117596801" ;
        System.out.println(largestBySwapParity(num));
        System.out.println(smallestBySwapParity(num));
        num = "8324795792429043209475973214" ;
        System.out.println(largestBySwapParity(num));
        System.out.println(smallestBySwapParity(num));
        num = "832479579242904320947597423498239482390840853590483209483248233214" ;
        System.out.println(largestBySwapParity(num));
        System.out.println(smallestBySwapParity(num));
    }
}
