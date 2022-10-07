package com.evo.ib.walmart.dp;

public class CoinChangeFewer {
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0 ;
        return  minCoins(coins, coins.length, amount) ;
    }
    public static int minCoins (int[] coins, int coinsLen, int amount) {
        int [] table = new int[amount+1] ;

        table[0] = 0 ;
        for (int i = 1 ; i <= amount ; ++i) {
            table[i] = Integer.MAX_VALUE ;
        }

        for (int i = 1 ; i <= amount ; i++) {
            for (int j = 0 ; j < coinsLen ; j++) {
                if (coins[j] <= i) {
                    int subRes = table[i-coins[j]] ;
                    if (subRes != Integer.MAX_VALUE && subRes+1 < table[i]) {
                        table[i] = subRes+1 ;
                    }
                }
            }
        }
        if (table[amount] == Integer.MAX_VALUE) return -1 ;
        return table[amount] ;
    }

    public static void main(String[] args) {
        int [] coins = {1, 2, 5} ;
        int amount = 11 ;

        System.out.println(coinChange(coins, 11) ) ;
    }
}
