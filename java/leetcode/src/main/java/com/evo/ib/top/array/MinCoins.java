package com.evo.ib.top.array;

public class MinCoins {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0 ;
        return  minCoins(coins, coins.length, amount) ;
    }

    public int minCoins (int[] coins, int coinsLen, int amount) {
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
        return table[amount] ;
    }

    public static void main (String[] args)
    {
        MinCoins minCoins = new MinCoins() ;
        //int coins[] = {1, 5, 10, 25};
        int [] coins = {2} ;
        int m = coins.length;
        int V = 3;
        System.out.println ( "Minimum coins required is "
                + minCoins.coinChange(coins, V));
    }
}
