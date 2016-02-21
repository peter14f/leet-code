
public class SolutionDP {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        
        for (int i=1; i<=n; i++) {
            dp[i] = i; // number of 1s needed
            
            for (int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i-j*j] + 1, dp[i]);
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        SolutionDP sol = new SolutionDP();
        
        int ans = sol.numSquares(1535);
        System.out.println(ans);
    }
    
}
