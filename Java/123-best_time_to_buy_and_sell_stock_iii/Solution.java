
public class Solution {

    public int maxProfit(int[] prices) {
    
        int maxProfit = maxProfitOne(prices, 0, prices.length-1);
        
        for (int i=1; i<prices.length-2; i++) {
            int profit = maxProfitOne(prices, 0, i) + maxProfitOne(prices, i+1, prices.length-1);
            if (profit > maxProfit)
                maxProfit = profit;
        }
        
        return maxProfit;
    }
    
    private int maxProfitOne(int[] prices, int low, int high) {
        int buyIndex = low;
        int maxProfit = 0;
        
        for (int i=low+1; i<=high; i++) {
            
            if (prices[i] < prices[buyIndex]) {
                buyIndex = i;
            }
            else {
                int profit = prices[i] - prices[buyIndex];
                if (profit > maxProfit) 
                    maxProfit = profit;
            }
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {1, 2, 3, 2, 3, 4};
        int maxProfit = sol.maxProfit(prices);
        
        System.out.println(maxProfit);
    }

}
