package org.problems;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyStocks {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    //Time complexity: O(n). Only a single pass is needed.
    //Space complexity: O(1). Only two variables are used.
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) minprice = prices[i];
            else if (prices[i] - minprice > maxprofit) maxprofit = prices[i] -
                    minprice;
        }
        return maxprofit;
    }
}
