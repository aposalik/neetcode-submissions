class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxprofit = 0;

        for(int i=0; i<prices.length; i++){
            if(prices[i] <= minPrice){
                minPrice = prices[i];
            }
            int profitToday = prices[i] - minPrice;
            if(profitToday >= maxprofit){
                maxprofit = profitToday;
            }
        }

        return maxprofit;
    }
}
