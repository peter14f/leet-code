import java.util.Arrays;


public class SolutionB {

    public int coinChange(int[] coins, int amount) {
        
        Arrays.sort(coins);
        
        //System.out.println(Arrays.toString(coins));
        
        int[] min = {Integer.MAX_VALUE};
        
        findFirstCombinationSum(coins, coins.length-1, 
                                0, 0, amount, min);
        
        return min[0];
    }
    
    private void findFirstCombinationSum(int[] coins, int coin, 
                                        int curSum, int curCoins, int target,
                                        int[] min) {
        
        if (coin < 0) {
            //System.out.println("curSum=" + curSum);
            if (curSum == target) {
                if (curCoins < min[0])
                    min[0] = curCoins;
            }
            return;
        }
        
        
        int diff = target - curSum;
        int mult = diff / coins[coin];
        
        // so you have (mult + 1) choices
        
        for (int k=mult; k>=0; k--) {
            
            int toAdd = coins[coin] * k;
            
            findFirstCombinationSum(coins, coin-1, 
                                    curSum + toAdd, 
                                    curCoins + k, target, min);
        }
    }
    
    public static void main(String[] args) {
        SolutionB sol = new SolutionB();
        int[] coins = {346,29,395,188,155,109};
        int numCoins = sol.coinChange(coins, 9401);
        System.out.println(numCoins);
    }

}
