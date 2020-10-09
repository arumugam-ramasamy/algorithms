package com.smic.practice.heap;

import java.util.PriorityQueue;

public class MaxPortfolio {

    double portfolio_value_optimization(double[] current_prices, double[] predicted_prices, int[] max_number_of_units, int dollars_to_spend) {
        // add defensive checks  current_prices.length, dollars_to_spend
        PriorityQueue<ProfitPair> profit_max = new
                PriorityQueue<ProfitPair>(current_prices.length);
        double[] allowed_to_buy = new double[current_prices.length];
        for (int i = 0; i < current_prices.length; i++) {
            double profit = predicted_prices[i] - current_prices[i];
            if (profit < 0) continue;
            double units = dollars_to_spend / current_prices[i];
            if (units > max_number_of_units[i]) units = (double) max_number_of_units[i];
            allowed_to_buy[i] = units;

            ProfitPair pair = new ProfitPair(i, units * profit);
            profit_max.offer(pair);
        }

        double portfolio = 0.0;

        if ((profit_max).peek().getProfit() == 0.0) return dollars_to_spend;

        while (dollars_to_spend > 0 && profit_max.size() > 0) {
            ProfitPair pair = profit_max.poll();
            if (pair.getProfit() == 0.0) break;
            double amount_to_subtract = current_prices[pair.getInd()] * allowed_to_buy[pair.getInd()];
            if (amount_to_subtract <= dollars_to_spend) {
                dollars_to_spend -= amount_to_subtract;
            } else {

                amount_to_subtract = dollars_to_spend;
                allowed_to_buy[pair.getInd()] = amount_to_subtract / current_prices[pair.getInd()];

            }
            portfolio += predicted_prices[pair.getInd()] * allowed_to_buy[pair.getInd()];

        }

        return (portfolio + dollars_to_spend);


    }

}



/*

You have N types of securities available to buy and for each security i, each has a starting price Pi. Your friend predicts that the stock price will be Si for each associated security. But based on volatility of the market, you only want to buy up to Ai shares of security i.

Given M dollars to spend, calculate the maximum return you could potentially gain based on the predicted prices Si (and including any cash you have remaining). You can think about this as the final portfolio value.

Assume you are able to buy fractional amounts of shares.

*/