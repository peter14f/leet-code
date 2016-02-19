
public class SolutionB {

    public int minCost(int[][] costs) {
        int n = costs.length;
        
        if (n == 0)
            return 0;
        
        int minCostR = costs[0][0];
        int minCostG = costs[0][1];
        int minCostB = costs[0][2];
        
        for (int i=1; i<n; i++) {
            int prevMinCostR = minCostR;
            int prevMinCostG = minCostG;
            int prevMinCostB = minCostB;
            
            minCostR = costs[i][0] + Math.min(prevMinCostG, prevMinCostB);
            minCostG = costs[i][1] + Math.min(prevMinCostR, prevMinCostB);
            minCostB = costs[i][2] + Math.min(prevMinCostR, prevMinCostG);
        }
        
        return Math.min(minCostR, Math.min(minCostG, minCostB));
    }
    
    public static void main(String[] args) {
        int[][] costs = {
                { 5, 8, 6},
                {19,14,13},
                { 7, 5,12},
                {14,15,17},
                { 3,20,10}
        };
        
        SolutionB sol = new SolutionB();
        int minCost = sol.minCost(costs);
        System.out.println(minCost);
    }

}
