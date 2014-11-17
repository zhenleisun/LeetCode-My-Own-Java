/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Show Tags
*/

package com.oj.practice;

public class BuySellStock {

    public int maxProfit(int[] prices) {
    	if(prices.length<=1)
    		return 0;
    	
    	int minPrice=prices[0];
    	int profit = 0;
    	
    	for(int i=1; i<prices.length-1; i++){
    		if(minPrice>prices[i]){
    			minPrice = prices[i];
    		}
    		
    		if(prices[i]>=prices[i-1] && prices[i]>=prices[i+1]){
    			int currentProfit = prices[i]-minPrice;
    			if(currentProfit>profit){
    				profit = currentProfit;
    			}
    		}
    	}
    	
    	if(prices[prices.length-1]-minPrice>profit){
    		return prices[prices.length-1]-minPrice;
    	}
    	
        return profit;
    }
    
    /** Another same way..
     * 
      if (prices.length == 0)
        {
            return 0;
        }

        int max = 0, min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] < min)
            {

                min = prices[i];
            }
            else
            {
                if (prices[i] - min > profit)
                {
                    profit = prices[i] - min;
                }

            }
        }

     return profit;
     *
     **/
}
