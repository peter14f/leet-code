
public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyIndex = 0;
        
        for (int i=1; i<prices.length; i++) {
            
            if (prices[i] < prices[buyIndex]) {
                buyIndex = i;
            }
            
            if (prices[i] - prices[buyIndex] > maxProfit) {
                maxProfit = prices[i] - prices[buyIndex];
            }
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
       Solution sol = new Solution();
       int[] prices = {3, 2, 1, 5, 1};
       int maxProfit = sol.maxProfit(prices);
       System.out.println(maxProfit);
    }

}
