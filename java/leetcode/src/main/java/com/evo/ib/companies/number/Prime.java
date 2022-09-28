package com.evo.ib.companies.number;

public class Prime {

    public static void primes(int n) {
        boolean [] prime = new boolean[n+1] ;
        for(int i=0;i<=n;i++)
            prime[i] = true;
        for (int i = 2 ;  i * i < n ; i++) {
            if (prime[i] == true) {
                for (int j = i * i ; j <= n ; j+= i) {
                    prime[j] = false ;
                }
            }
        }
        for (int i = 2 ; i <= n ; i++) {
            if (prime[i] == true){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        primes(100);
    }
}
