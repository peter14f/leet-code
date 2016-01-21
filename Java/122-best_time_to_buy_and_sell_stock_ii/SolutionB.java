
public class SolutionB {

    public int maxProfit(int[] prices) {
        int profit = 0;
        
        for (int i=1; i<prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                profit += prices[i] - prices[i-1];
            }
        }
        
        return profit;
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        int[] prices = {5, 7, 4, 3, 1, 2, 3};
        int profit = sol.maxProfit(prices);
        System.out.println(profit);
    }

}
