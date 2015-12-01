

public class SolutionDP {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        
        int[] profit1 = new int[prices.length];
        int[] profit2 = new int[prices.length];
        
        /* profit1[i] is the maximum profit considering prices[0..i] and with at most
         * one transaction
         * 
         * profit2[i] is the maximum profit considering prices[i, n-1] and with at most
         * one transaction
         * 
         */
        
        int buyIndex = 0;
        int maxProfit1 = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < prices[buyIndex]) {
                buyIndex = i;
            }
            else {
                int p = prices[i] - prices[buyIndex];
                if (p > maxProfit1) {
                    maxProfit1 = p;
                }
            }
            profit1[i] = maxProfit1;
        }
        
        int sellIndex = profit2.length - 1;
        int maxProfit2 = 0;
        for (int i=profit2.length-2; i>=0; i--) {
            if (prices[i] > prices[sellIndex]) {
                sellIndex = i;
            }
            else {
                int p = prices[sellIndex] - prices[i];
                if (p > maxProfit2) {
                    maxProfit2 = p;
                }
            }
            profit2[i] = maxProfit2;
        }
        
        int maxProfit = 0;
        for (int i=0; i< prices.length; i++) {
            int p = profit1[i] + profit2[i];
            if (p > maxProfit)
                maxProfit = p;
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
        SolutionDP sol = new SolutionDP();
        int[] prices = {2, 1, 2, 0, 1};
        int maxProfit = sol.maxProfit(prices);
        System.out.println(maxProfit);
    }

}
