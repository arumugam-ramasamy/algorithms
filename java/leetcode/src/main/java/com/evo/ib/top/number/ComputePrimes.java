package com.evo.ib.top.number;

public class ComputePrimes {
    public int countPrimesEff(int n) {
        if(n < 3)
            return 0;

        boolean[] primes = new boolean[n];
        int count = 1;
        for(int p = 3; p < n; p += 2) {
            if(!primes[p]) {
                count++;
                for(int i = p * 3; i < n; i += p * 2)
                    primes[i] = true;
            }
        }

        return count;
    }
    public int countPrimes(int n) {
        int primeCount = 0 ;
        if (n < 3) return 0 ;
        if (n == 3) return 1 ;
        if (n == 4) return 2 ;
        primeCount = 2 ;
        for (int i = 5 ; i < n  ; i+= 2) {
            if (i %3 == 0)continue;
            if (isPrime(i))
                ++primeCount ;
        }
        return primeCount ;
    }

    public boolean isPrime(int prime) {
        if (prime %2 == 0) return  false ;
        for (int i = 3; i*i <= prime ; i++){
            if (prime %i == 0) return false ;
        }
        return  true ;
    }

    public static void main(String[] args) {
        ComputePrimes computePrimes = new ComputePrimes() ;
        System.out.println(computePrimes.countPrimesEff(1200));
    }
}
