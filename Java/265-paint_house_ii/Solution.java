
public class Solution {

    public int minCostII(int[][] costs) {
        int n = costs.length;
        
        if (n==0)
            return 0;
        
        int k = costs[0].length;
        
        if (k==0)
            return 0;
        
        /*  minCostWithColor[i][j] is the 
         *    minimum total cost up to house i with the ith painted in color j
         * 
         */
        int[][] minCostWithColor = new int[n][k];
        
        for (int j=0; j<k; j++) {
            minCostWithColor[0][j] = costs[0][j];
        }
        
        for (int i=1; i<n; i++) {
            for (int j=0; j<k; j++) {
                // you want to paint the ith house color j
                // then the previous house cannot be painted with color j
                int prevMin = Integer.MAX_VALUE;
                
                for (int p=0; p<k; p++) {
                    if (p==j)
                        continue;
                    if (minCostWithColor[i-1][p] < prevMin) {
                        prevMin = minCostWithColor[i-1][p];
                    }
                }
                
                minCostWithColor[i][j] = prevMin + costs[i][j];
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        
        for (int j=0; j<k; j++) {
            if (minCostWithColor[n-1][j] < minCost) {
                minCost = minCostWithColor[n-1][j];
            }
        }
        
        return minCost;
    }
    
    public static void main(String[] args) {
        int[][] costs = {
                {5,8,6},
                {19,14,13},
                {7,5,12},
                {14,15,17},
                {3,20,10}
        };
        
        Solution sol = new Solution();
        int minCost = sol.minCostII(costs);
        
        System.out.println(minCost);
    }

}
