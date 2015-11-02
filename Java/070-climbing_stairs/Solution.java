
public class Solution {
    
    // 0 1 2 3 4
    // 1 1 2 3 5
    
    // 1 1 1 1
    // 1 2 1 
    // 1 1 2
    // 2 1 1
    // 2 2
    public int climbStairs(int n) {
        
        int[] waysToReachStep = new int[n+1];
        
        if (n < 1)
            throw new IllegalArgumentException();
            
        waysToReachStep[0] = 1; // ground
        waysToReachStep[1] = 1; // take one step from ground
        // [2]: take 2 steps from ground 
        //      take 1 step to Step 1, take 1 step to Step 2
        
        for (int i=2; i<=n; i++) {
            waysToReachStep[i] = waysToReachStep[i-1] + waysToReachStep[i-2];
        }
        
        return waysToReachStep[n];
    }
    
    public static void main(String[] args) {
        
    }

}
