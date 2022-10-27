package com.evo.ib.recursion;

public class CoinChange {

    public static int minCoins (int value, int[] coins) {
        int [] cache = new int[value] ;
        for (int i = 1 ; i < value ; i++) cache[i] = -1 ;
        return  minCoinsChanges (value, coins, cache) ;
    }

    public static int minCoinsChanges (int value, int[] coins, int[] cache) {
        if (value == 0 ) return 0 ;

        int min = value ;

        for (int coin : coins) {
            if (value - coin >= 0) {
                int c ;
                if (cache[value - coin] >= 0) c = cache[value - coin] ;
                else {
                    c = minCoinsChanges(value - coin, coins, cache);
                    cache[value - coin] = c ;
                }
                if (c+1 < min) min = c + 1 ;
            }
        }
        return min ;
    }

    public static void main(String[] args) {
        int [] coins = {1, 5,10, 25, 50, 100} ;

        System.out.println(minCoins(152, coins));
    }
}
