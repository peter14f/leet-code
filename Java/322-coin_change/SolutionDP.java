import java.util.Arrays;


public class SolutionDP {

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount+1];
        
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));
        
        // first column
        for (int i=0; i<dp.length; i++) {
            dp[i][0] = 0;
        }
        
        // first row
        for (int j=1; j<=amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        
        // access the coin denomination with coins[i-1]
        // 
        // 
        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<=amount; j++) {
                int minCoins = Integer.MAX_VALUE;
                
                for (int k = j/coins[i-1]; k >= 0; k--) {
                    
                    
                    int amountAfterK = j - (k*coins[i-1]);
                    
                    
                    /*System.out.println("k=" + k + " amountAfterK=" + amountAfterK + " " + 
                                       dp[i-1][amountAfterK]);*/
                    
                    int numCoins = k + dp[i-1][amountAfterK];
                    
                    // overflow
                    if (numCoins < 0)
                        numCoins = Integer.MAX_VALUE;
                    
                    minCoins = Math.min(minCoins, numCoins);
                }
                
                //System.out.println(" min=" + minCoins);
                
                if (minCoins == Integer.MAX_VALUE)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = minCoins;
            }
        }
        
        //System.out.println(Arrays.deepToString(dp));
        
        if (dp[coins.length][amount] == Integer.MAX_VALUE)
            return -1;
        else
            return dp[coins.length][amount];
    }
    
    public static void main(String[] args) {
        int[] coins = {456, 117, 5, 145};
        int amount = 1459;
        
        SolutionDP sol = new SolutionDP();
        int minCoins = sol.coinChange(coins, amount);
        
        System.out.println(minCoins);
    }

}
