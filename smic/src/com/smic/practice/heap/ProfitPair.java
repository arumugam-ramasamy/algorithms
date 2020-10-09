package com.smic.practice.heap;

class ProfitPair implements  Comparable<ProfitPair> {
    public int ind ;
    public double profit;

    // A parameterized student constructor
    public ProfitPair(int ind, double profit) {

        this.ind = ind;
        this.profit = profit ;
    }

    public int getInd() {
        return ind;
    }

    public double getProfit() {
        return profit ;
    }

    @Override
    public int compareTo(ProfitPair o) {
        if (this.getProfit() > o.getProfit()) return 1 ;
        if (this.getProfit() < o.getProfit()) return -1 ;
        return 0;
    }
}
