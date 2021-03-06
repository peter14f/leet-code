
public class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        if (k >= n/2)
            return maxProfitAsMany(prices);
        
        /* before we make any trade, our cash position is 0 
         * buying a stock at price p reduces our cash position to -p
         * selling a stock at price z increases our cash position to (-p + z)
         * and the final cash position we're left with is the profit we make
         */
        
        /* allPositionClosed[i][j] - the max profit we have realized at j-th day with at most
         * i trades, and all we hold is cash.
         * 
         * at j-th day, we can choose to use and not use the j-th price. 
         * 
         * If we do not use the j-th price, then we have cash position allPositionClosed[i][j-1], 
         * i.e., yesterday's cash position.
         * 
         * If we choose the j-th price, we must pair it with a previous naked buy position because 
         * we want to exit with cash and without any stocks.
         * 
         * minEffectOneNakedBuy + prices[j] precisely does this. Here we use "+" because after sell, 
         * we keep prices[j] in pocket 
         * 
         */
        int[][] allPositionClosed = new int[k+1][n];
        
        /* minEffectOneNakedBuy - the minimum effect on our cash position when we hold a single 
         * buy position considering the prices in the past
         * 
         * t is the current day
         * 
         *  (remember, buy always lowers our cash position, that's why oneNakedBuyPosition is 
         *  initialized to -prices[0], indicated exactly by its name, after we open a naked buy,
         *  it lowers our cash position to -prices[0].)
         * 
         */
        
        for (int m=1; m<=k; m++) {
            int minEffectOneNakedBuy = -prices[0];
            
            for (int t=1; t<prices.length; t++) {
                allPositionClosed[m][t] = Math.max(allPositionClosed[m][t-1], 
                                                   minEffectOneNakedBuy + prices[t]);
                minEffectOneNakedBuy = Math.max(minEffectOneNakedBuy, 
                                                allPositionClosed[m-1][t-1] - prices[t]);
            }
        }
        
        return allPositionClosed[k][prices.length-1];
    }
    
    private int maxProfitAsMany(int[] prices) {
        int profit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int[] prices = {6, 1, 0, 4};
        
        Solution sol = new Solution();
        int maxProfit = sol.maxProfit(1, prices);
        System.out.println(maxProfit);
    }

}
