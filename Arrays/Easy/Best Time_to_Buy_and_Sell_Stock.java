/*
Maintain the minimum of the array.
And the maximum profit is the difference of the minimum of the array (only till that index) and the value of the array on that index.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
