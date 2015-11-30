
public class Solution {

    // multiple tranactions allowed
    public int maxProfit(int[] prices) {
        
        int buyIndex = 0;
        int sellIndex = 0;
        int profit = 0;
        
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < prices[buyIndex]) {
                if (sellIndex > buyIndex)
                    profit += prices[sellIndex] - prices[buyIndex];
                
                buyIndex = i;
                sellIndex = i;
            }
            else if (prices[i] < prices[sellIndex]) {
                if (sellIndex > buyIndex)
                    profit += prices[sellIndex] - prices[buyIndex];
                
                buyIndex = i;
                sellIndex = i;
            }
            else if (prices[i] > prices[buyIndex]) {
                sellIndex = i;
            }
        }
        
        if (sellIndex > buyIndex)
            profit += prices[sellIndex] - prices[buyIndex];
        
        return profit;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {1, 2, 3, 2, 3, 4};
        int maxProfit = sol.maxProfit(prices);
        System.out.println(maxProfit);
    }

}
