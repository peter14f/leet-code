
public class Solution {

    public int minCost(int[][] costs) {
        int n = costs.length;
        
        if (n==0)
            return 0;
        
        // minCostR[i] is the minimum cost up to the ith house 
        // with the ith house painted red 
        int[] minCostR = new int[n];
        
        // minCostG[i] is the minimum cost up to the ith house
        // with the ith house painted green
        int[] minCostG = new int[n];
        
        // minCostB[i] is the minimum cost up to the ith house
        // with the ith house painted blue
        int[] minCostB = new int[n];
        
        minCostR[0] = costs[0][0];
        minCostG[0] = costs[0][1];
        minCostB[0] = costs[0][2];
        
        for (int i=1; i<n; i++) {
            
            // minCost if I'm painting the ith house Red
            // prevHouse has got to be Blue or Green
            minCostR[i] = Math.min(minCostB[i-1], minCostG[i-1]) + costs[i][0];
            
            // minCost if I'm painting the ith house Green
            // prevHouse has got to be Red or Blue
            minCostG[i] = Math.min(minCostR[i-1], minCostB[i-1]) + costs[i][1];
            
            // minCost if I'm painting the ith house Blue
            // prevHouse has got to be Red or Green
            minCostB[i] = Math.min(minCostR[i-1], minCostG[i-1]) + costs[i][2];
        }
        
        return Math.min(minCostR[n-1], Math.min(minCostG[n-1], minCostB[n-1]));
    }
    
    public static void main(String[] args) {
        int[][] costs = {
                { 5, 8, 6},
                {19,14,13},
                { 7, 5,12},
                {14,15,17},
                { 3,20,10}
        };
        
        Solution sol = new Solution();
        int minCost = sol.minCost(costs);
        System.out.println(minCost);
    }

}
