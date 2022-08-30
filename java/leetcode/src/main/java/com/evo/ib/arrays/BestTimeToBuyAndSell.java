package com.evo.ib.arrays;

/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */

import java.util.Arrays;

public class BestTimeToBuyAndSell {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp=new int[n][2];
        for(int[] row:dp) Arrays.fill(row,-1);
        return maxProfit(0,1,prices,dp);
    }

    public static int maxProfit( int i, int k,
    int[] prices, int[][] dp)
    {

        if(i == prices.length) return 0;
        if(dp[i][k] != -1) return dp[i][k];
        int profit = 0;
        if(k == 1){
            int buy = -prices[i] + maxProfit(i+1,0,prices,dp);
            int notBuy = maxProfit(i+1,1,prices,dp);
            profit = Math.max(buy,notBuy);
        }else{
            int sell = prices[i] + maxProfit(i+1,1,prices,dp);
            int notSell = maxProfit(i+1,0,prices,dp);
            profit = Math.max(sell, notSell);
        }

        return dp[i][k] = profit;
    }

}
