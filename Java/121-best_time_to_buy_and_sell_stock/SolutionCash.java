
public class SolutionCash {

    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        
        /* before we make any trade, our cash position is 0 
         * buying a stock reduces our cash position to a negative number
         * selling a stock increases our cash position and the final cash
         * position we're left with is the profit we make
         */
        int n = prices.length;
        
        /* allPositionClose[i] is the maximum cash position considering prices 
         * 0, ..., i.
         */
        int[] allPositionClosed = new int[n];
        
        /* the minimum effect on our cash position considering all prices in the past 
         * (t is current day)
         */
        int oneNakedBuy = -prices[0];
        
        for (int t=1; t<n; t++) {
            /* so whenever we encounter a new stock price, we can choose to sell the stock
             * at this price 
             * 
             * OR
             * 
             * ignore the stock price and be content with the cash position we have so far
             */
            
            allPositionClosed[t] = Math.max(allPositionClosed[t-1], oneNakedBuy + prices[t]);
            
            /* so either a buy in the past yields a lower impact on the cash position or 
             * a buy in this new price yields a lower impact on the cash position
             * 
             * remember the larger negative number is the one that yields a smaller impact
             * on our cash position
             */
            oneNakedBuy = Math.max(oneNakedBuy, -prices[t]);
        }
        
        return allPositionClosed[n-1];
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
