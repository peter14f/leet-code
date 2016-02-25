import java.util.Arrays;


public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        if (n<=1)
            return 0;
        
        int[] buy = new int[n];
        int[] sell = new int[n];
        
        // buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i])
        // sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i])
        
        
        buy[0] = -prices[0];
        sell[0] = 0;
        
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        buy[1] = Math.max(buy[0], 0 - prices[1]);
        
        for (int i=2; i<n; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        
        //System.out.println(Arrays.toString(buy));
        //System.out.println(Arrays.toString(sell));
        
        return sell[n-1];
    }
    
    public static void main(String[] args) {
        int[] prices = {1, 2, 4};
        Solution sol = new Solution();
        
        int maxProfit = sol.maxProfit(prices);
        System.out.println(maxProfit);
    }

}
