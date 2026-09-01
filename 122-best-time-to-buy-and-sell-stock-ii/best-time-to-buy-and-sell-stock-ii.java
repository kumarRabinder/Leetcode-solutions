class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for(int i=1;i<prices.length; i++){
            int profit = 0;
            if(prices[i] > prices[i-1]){
                profit = prices[i] - prices[i-1];
                maxprofit += profit;
            }
        }
        return maxprofit;
    }
}